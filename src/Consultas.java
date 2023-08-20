import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Consultas {

    private Dados dados;
    private Predicate<RegistroDoTempo> condicao;

    public Consultas(Dados dados) {
        this.dados = dados;
        condicao = r -> ((RegistroDoTempo) r).getDia() > 20;
    }

    public List<String> datasEmQueChouveuMaisDe(double milimetros) {
        return dados.retornaDados()
                .stream()
                .filter(r -> r.getPrecipitacao() > milimetros)
                .map(r -> r.getDia() + "/" + r.getMes() + "/" + r.getAno())
                .toList();
    }

    public String diaQueMaisChoveuNoAno(int ano) {
        RegistroDoTempo registro = dados.retornaDados()
                .stream()
                .filter(reg -> reg.getAno() == ano)
                .max(Comparator.comparing(RegistroDoTempo::getPrecipitacao))
                .orElseThrow(IllegalArgumentException::new);
        String resp = registro.getDia() + "/" + registro.getMes() + "/" + registro.getAno() + ", "
                + registro.getPrecipitacao();
        return resp;
    }

    public List<Data> diasEmQue(List<RegistroDoTempo> lista) {
        List<Data> dataNova = new ArrayList<>();

        for (RegistroDoTempo registro : lista) {
            if (condicao.test(registro)) {
                Data data = new Data(registro, registro.getDia(), registro.getMes(), registro.getAno());
                dataNova.add(data);
            }
        }

        return dataNova;
    }

    void alteraConsultaPadrao(Predicate<RegistroDoTempo> consulta) {
        this.condicao = consulta;
    }
}

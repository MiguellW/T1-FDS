import java.util.List;

interface IDados {
    void carregaDados(String fonte);
    List<RegistroDoTempo> retornaDados();
}

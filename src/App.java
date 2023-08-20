public class App {
    public static void main(String[] args) {

        String nome = "Dados//poa_temps.txt";

        Dados dados = new Dados(nome);

        Consultas consultas = new Consultas(dados);

        // Testes padrões

        System.out.println("Dia em que mais choveu no ano de 1980: ");
        System.out.println(consultas.diaQueMaisChoveuNoAno(1980));

        System.out.println("Datas em que choveu mais de 90 milimetros");
        System.out.println(consultas.datasEmQueChouveuMaisDe(90));

        // Testes do novo método
        // Condição padrão: dia do mês > 20
        System.out.println(consultas.diasEmQue(dados.retornaDados()));

        // Condição alterada: ano deve ser maior que 2019
        consultas.alteraConsultaPadrao(r -> r.getAno() > 2019);
        System.out.println(consultas.diasEmQue(dados.retornaDados()));

    }
}

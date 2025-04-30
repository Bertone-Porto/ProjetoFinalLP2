public class Data {
    private int dia, mes, ano;

    public Data(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    /*public Data(){
        this.dia = 0;
        this.mes = 0;
        this.ano = 0;
    }*/

    public boolean ehBissexto(){
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }

    public boolean ehValida(){
        if(ano < 1 || mes < 1 || mes > 12 || dia <1){
            return false;
        }
        switch (mes){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return dia <= 31;
            case 4: case 6: case 9: case 11:
                return dia <= 30;
            case 2:
                if(ehBissexto()){
                    return dia <= 29;
                } else {
                    return dia <= 28;
                }
            default:
                return false;
        }
    }

    public void imprime(){
        imprime("/");
    }
    public void imprime(String separador){
        if(ehValida()){
            System.out.println(dia + separador + mes + separador + ano);
        } else{
            System.out.println("Data inválida");
        }
    }



}

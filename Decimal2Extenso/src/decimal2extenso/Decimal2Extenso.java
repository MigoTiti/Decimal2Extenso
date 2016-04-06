package decimal2extenso;

public class Decimal2Extenso {

    public static void main(String[] args) {
        boolean cVazio, dVazio, uVazio;
        int num = 99;
        
        int centena = num/100;
        cVazio = centena==0;
        
        int dezena = num%100;
        dezena = dezena/10;
        dVazio = dezena==0;
        
        int unidade = num%10;
        uVazio = unidade==0;
        
        StringBuilder numExten = new StringBuilder();
        
        
        if(cVazio&&dVazio&&uVazio)
            numExten.append(UNIDADES[0]);
        else if(!cVazio&&dVazio&&uVazio)
            switch(centena){
                case 1:
                    numExten.append(CENTENAS[0]);
                    break;
                case 2:
                    numExten.append(CENTENAS[2]);
                    break;
                case 3:
                    numExten.append(CENTENAS[3]);
                    break;
                case 4:
                    numExten.append(CENTENAS[4]);
                    break;
                case 5:
                    numExten.append(CENTENAS[5]);
                    break;
                case 6:
                    numExten.append(CENTENAS[6]);
                    break;
                case 7:
                    numExten.append(CENTENAS[7]);
                    break;
                case 8:
                    numExten.append(CENTENAS[8]);
                    break;
                case 9:
                    numExten.append(CENTENAS[9]);
                    break;
            }
        else if(!cVazio){
            String aux = definirCentena(centena);
            if(!dVazio||!uVazio)
                numExten.append(aux).append(" e ");
            if(!dVazio){
                String auxD = definirDezena(dezena,unidade);
                numExten.append(auxD);
                if(dezena!=1&&!uVazio){
                    String auxU = definirUnidade(unidade);
                    numExten.append(" e ").append(auxU);
                }
            }
        }else if(!dVazio){
            String auxD = definirDezena(dezena,unidade);
            numExten.append(auxD);
            if(dezena!=1&&!uVazio){
                String auxU = definirUnidade(unidade);
                numExten.append(" e ").append(auxU);
            }
        }else if(!uVazio){
            String auxU = definirUnidade(unidade);
            numExten.append(auxU);
        }
            
        System.out.println(numExten.toString());
    }
    
    private static String definirCentena(int centena){
        return CENTENAS[centena];
    }
    
    private static String definirDezena(int dezena, int unidade){
        if(dezena==1)
            return DEZENAS[unidade];
        else
            return DEZENAS[dezena+8];
    }
    
    private static String definirUnidade(int unidade){
        return UNIDADES[unidade];
    }
    
    private static final String[] CENTENAS = new String[]{"cem","cento","duzentos","trezentos","quatrocentos","quinhentos","seiscentos","setessentos","oitocentos","novecentos"};
    private static final String[] DEZENAS = new String[]{"dez","onze","doze","treze","quatorze","quinze","dezesseis","dezessete","dezoito","dezenove","vinte",
                                                         "trinta","quarenta","cinquenta","sessenta","setenta","oitenta","noventa"};
    private static final String[] UNIDADES = new String[]{"zero","um","dois","três","quatro","cinco","seis","sete","oito","nove"};
}

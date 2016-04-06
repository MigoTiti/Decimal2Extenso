package decimal2extenso;

public class Decimal2Extenso {

    public static void main(String[] args) {
        boolean cVazio, dVazio, uVazio;
        int num = 220;
        
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
            numExten.append(CENTENAS[0]);
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

package gestion;
import java.util.Random;
import java.util.Arrays;
import lombok.Getter;

@Getter
public class OperacionesNumero {
    private int[] numero = new int[4];
    public OperacionesNumero(){
        Verificar ver=new Verificar();
        Random geneRandom=new Random();
        
        int x1,x2,x3,x4;
        x1= geneRandom.nextInt(10);
        do { 
            x2= geneRandom.nextInt(10);
        } while (ver.verificarDatos2(x1, x2));

        do { 
            x3= geneRandom.nextInt(10);
        } while (ver.verificarDatos3(x1, x2, x3));

        do {
            x4= geneRandom.nextInt(10);
        } while (ver.verificarDatos4(x1, x2, x3, x4));

        numero[0]=x1;
        numero[1]=x2;
        numero[2]=x3;
        numero[3]=x4;

        System.out.println(Arrays.toString(numero));
    }
    public int[] getNumero() {
        return numero;
    }
    public int getNumeroInt (){
        return numero[0]*1000+numero[1]*100+numero[2]*10+numero[3];
    }
}

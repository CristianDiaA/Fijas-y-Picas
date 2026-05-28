package gestion;

public class Verificar {
        public boolean verificarDatos2(int x,int y){
            if (x==y    ){
                return true;
            }else{
            return false;
        }
    }
        public boolean verificarDatos3(int x,int y,int c){
            if (x==y || x==c | y==c){
                return true;
            }else{
            return false;
        }
    }
        public boolean verificarDatos4(int x,int y,int c,int z){
            if (x==y || x==c || x==z || y==c || y==z || c==z){
                return true;
            }else{
            return false;
        }
    }

}
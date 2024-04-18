public class Dias {
    public enum Dia {
        LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO
    }
    public class EnumTest{
        Dia dia;
        public EnumTest(Dia dia){
            this.dia = dia;
        }
        public void TellItLikeItIs(){
            switch (dia){
                case LUNES:
                    System.out.println("Lunes es un día de trabajo.");
                    break;
                case MARTES:
                    System.out.println("Martes es un día de pizza.");
                    break;
                case MIERCOLES:
                    System.out.println("Miercoles es un día de sacar al perro.");
                    break;
                case JUEVES:
                    System.out.println("Jueves es un día de hacer ejercicio.");
                    break;
                case VIERNES:
                    System.out.println("Viernes es un día de fiesta.");
                    break;
                case SABADO:
                    System.out.println("Sabado es un día de salir a pasear.");
                    break;
                case DOMINGO:
                    System.out.println("Domingo es un día de descanso.");
                    break;

            }

        }

    }

    public static void main(String[] args) {
        Dias.EnumTest firstDay = new Dias().new EnumTest(Dia.LUNES);
        firstDay.TellItLikeItIs();
        Dias.EnumTest thirdDay = new Dias().new EnumTest(Dia.MIERCOLES);
        thirdDay.TellItLikeItIs();
        Dias.EnumTest fifthDay = new Dias().new EnumTest(Dia.VIERNES);
        fifthDay.TellItLikeItIs();
        Dias.EnumTest seventhDay = new Dias().new EnumTest(Dia.DOMINGO);
        seventhDay.TellItLikeItIs();
    }
}

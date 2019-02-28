package adaptadores;

/**
 *
 * @author cromerofajar
 */
public class Adaptadores {

    public static void main(String[] args) {
        
        MediaPlayer player = new MP3(); //Creamos un objeto de tipo MP3
        player.play("file.mp3"); //Realizamos una llamada
        player = new FormatAdapter(new MP4()); //Tras crear la clase FormatAdapter le cambiamos a player los datos por los de FormatAdapter el cual recive los datos de la clase MP4
        player.play("file.mp4"); //Realizamos una llamada para comprobar que funciona con el formato MP3 y que pasa por el adapter
        player = new FormatAdapter(new VLC()); //Realizamos lo mismo de antes pero esta vez con los datos de VLC
        player.play("file.avi"); //Realizamos una llamada para comprobar que funciona con el formato MP3 y que pasa por el adapter
    }

    private static class FormatAdapter implements MediaPlayer {//creamos la clase FormatAdapter y ponemos los medios de adaptacion

        private MediaPackage media; //creamos un objeto de tipo MediaPackage

        public FormatAdapter(MediaPackage m) {
            media = m;//Cojemos el paquete.
        }//transformamos los objetos MediaPackage para poder adaptarlarlos

        @Override
        public void play(String filename) {
            System.out.print("Using Adapter --> ");
            media.playFile(filename);
        }//sobre escribimos play con los datos nuevos
    }
}
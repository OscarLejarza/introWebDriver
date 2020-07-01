package tareas;

public class LoginSongsBySinatra extends SongsSinatraParent {
    public static void main(String[] args) {
        navegar("https://evening-bastion-49392.herokuapp.com/");
        validarHomePage();
        realizarLoginCorrecto("frank", "sinatra");
        validarHompePage();
        validarMensajeBienvenida("You are now logged in as frank");
        cerrarBrowser();
    }




    
}

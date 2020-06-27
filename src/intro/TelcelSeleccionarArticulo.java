package intro;

import classExercise.Celular;
import org.openqa.selenium.WebDriver;

public class TelcelSeleccionarArticulo {

    static WebDriver driver;

    public static void main(String[] args) {
        navegarSitio("https://www.telcel.com");
        verificarLandingPage();
        listarTelefonos();
        verificarPaginaResultados();
        Celular primerCelular = capturarDatosCelular(1);
        seleccionarCelular(1);
        
    }
}

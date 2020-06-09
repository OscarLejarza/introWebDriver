package classExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassExercise_TelcelSeleccionarArticulo {

    static WebDriver driver;

    public static void main(String[] args) {
        navegarSitio("https://www.telcel.com");
        verificarLandingPage();
        listarTelefonos();
        seleccionarEstado("Jalisco");
        verificarPaginaResultados();
        Celular primerCelular;
        primerCelular = capturarDatosCelular(1);
        seleccionarCelular(1);
        validarDatosCelular(primerCelular);
    }



    private static void navegarSitio(String url) {
        driver = new ChromeDriver();

        driver.navigate().to(url);
    }

    private static void verificarLandingPage() {
        //verificar que existen estos elementos
//        logoTelcel:  css="[src='/content/dam/htmls/img/icons/logo-telcel.svg']"
        WebElement logoTelcel = driver.findElement(By.cssSelector("[src='/content/dam/htmls/img/icons/logo-telcel.svg']"));
        WebElement tiendaEnLinea = driver.findElement(By.cssSelector("[data-nombreboton='Tienda en linea superior']"));
        WebElement campoBusqueda = driver.findElement(By.cssSelector("#buscador-menu-input"));
        if(logoTelcel.isDisplayed() &&
                tiendaEnLinea.isDisplayed() &&
                campoBusqueda.isDisplayed() && campoBusqueda.isEnabled()) {
            System.out.println("Si cargo la pagina principal de telcel");
        } else {
            System.out.println("No cargo la pagina");
            System.exit(-1);
        }
//        linkTiendaEnLinea:css="[data-nombreboton='Tienda en linea superior']"

//        campoBusqueda: css= "#buscador-menu-input" 


    }

    private static void listarTelefonos() {
        WebElement tiendaEnLinea = driver.findElement(By.cssSelector("[data-nombreboton='Tienda en linea superior']"));
        tiendaEnLinea.click();
        WebElement linkTelefonosCelulares = driver.findElement(By.cssSelector(".shortcut-container [data-nombreboton='Telefonos y smartphones']"));
        linkTelefonosCelulares.click();
    }

    private static void seleccionarEstado(String nombreEstado) {
    }

    private static void verificarPaginaResultados() {
    }

    private static Celular capturarDatosCelular(int i) {
        return null;
    }

    private static void seleccionarCelular(int numCelular) {
    }

    private static void validarDatosCelular(Celular primerCelular) {
    }

}

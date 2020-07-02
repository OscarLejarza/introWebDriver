package classExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TelcelParent {

    static WebDriver driver;
    static WebDriverWait wait;

    public static void navegarSitio(String url) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 30);
        driver.navigate().to(url);
    }

    public static void verificarLandingPage() {
        // verificar que existen estos elementos
        // logoTelcel:
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[src='/content/dam/htmls/img/icons/logo-telcel.svg']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-nombreboton='Tienda en linea superior']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#buscador-menu-input")));
//        WebElement logoTelcel = driver.findElement(By.cssSelector("[src='/content/dam/htmls/img/icons/logo-telcel.svg']"));
//        WebElement tiendaEnLinea = driver.findElement(By.cssSelector("[data-nombreboton='Tienda en linea superior']"));
//        WebElement campoBusqueda = driver.findElement(By.cssSelector("#buscador-menu-input"));
/*        if (logoTelcel.isDisplayed() &&
                tiendaEnLinea.isDisplayed() &&
                campoBusqueda.isDisplayed() && campoBusqueda.isEnabled()){
            //       if (driver.findElement(By.cssSelector("[src='/content/dam/htmls/img/icons/logo-telcel.svg']")).isDisplayed() &&
            //               driver.findElement(By.cssSelector("[data-nombreboton='Tienda en linea superior']")).isDisplayed() &&
            //               driver.findElement(By.cssSelector("#buscador-menu-input")).isDisplayed()) {
            System.out.println("Si cargo la pagina principal de telcel");
        } else {
            System.out.println("No cargo la pagina");
            System.exit(-1); // Para indicar que es un error, si aparece 0 es que no hay error
        }*/
        // linkTiendaEnLinea
        // campoBusqueda

    }

    public static void listarTelefonos() {
        WebElement tiendaEnLinea = driver.findElement(By.cssSelector("[data-nombreboton='Tienda en linea superior']"));
        tiendaEnLinea.click();
        WebElement linkTelefonosCelulares = driver.findElement(By.cssSelector(".shortcut-container [data-nombreboton='Telefonos y smartphones']"));
        linkTelefonosCelulares.click();
    }

    public static void seleccionarEstado(String nombreEstado) {
        System.out.println("breakpoint instruction.");
        WebElement seleccionaEstadoDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal .chosen-single")));
        seleccionaEstadoDropdown.click();
//        WebElement seleccionaEstadoDropdown = driver.findElement(By.cssSelector(".modal .chosen-single"));
/*        if (seleccionaEstadoDropdown.isDisplayed()){
            seleccionaEstadoDropdown.click();
        } else {
            System.out.println("Falló el modal");
            System.exit(-1);
        }*/
        WebElement inputEstado = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".chosen-search input")));
        inputEstado.sendKeys(nombreEstado);
        WebElement opcionEstado = driver.findElement(By.cssSelector(".chosen-results li"));
        opcionEstado.click();
        WebElement botonEntrar = driver.findElement(By.id("entrarPerfilador"));
        botonEntrar.click();
    }

    public static void verificarPaginaResultados() {
        List<WebElement> celulares = driver.findElements(By.cssSelector(".comp-telcel-mosaico-equipos li"));
        System.out.println(celulares.size());
        if (celulares.size() > 1) {
            System.out.println("La lista se desplego correctamente");
        }
    }

    public static Celular capturarDatosCelular(int i) {
        WebElement textoMarcaModelo = driver.findElement(By.cssSelector(".telcel-mosaico-equipos-marca"));
        String mm = textoMarcaModelo.getText();

        WebElement textoNombre = driver.findElement(By.cssSelector(".telcel-mosaico-equipos-nombre-equipo"));
        String nombreEquipo = textoNombre.getText();

        WebElement textoPrecio = driver.findElement(By.cssSelector(".telcel-mosaico-equipos-precio"));
        String precioEquipo = textoPrecio.getText();
        precioEquipo = precioEquipo.replace(",", "");
        precioEquipo = precioEquipo.replace("$", "");
        double pe = Double.parseDouble(precioEquipo);

        WebElement textoCapacidad = driver.findElement(By.cssSelector(".telcel-mosaico-equipos-capacidad-numero"));
        String capacidadEquipo = textoCapacidad.getText();
        String[] datos = capacidadEquipo.split(" ");
        String capacidadString = datos[0];
        int numGigas = Integer.parseInt(capacidadString);

        return new Celular(mm, nombreEquipo, pe, numGigas);

    }


    public static void seleccionarCelular(int numCelular) {
        List<WebElement> celulares = driver.findElements(By.cssSelector(".comp-telcel-mosaico-equipos li"));
        System.out.println(celulares.size());
        WebElement celular = celulares.get(numCelular - 1);
        celular.click();
    }

    public static void validarDatosCelular(Celular primerCelular){
        WebElement textoMarcaModelo = driver.findElement(By.cssSelector(".ecommerce-ficha-tecnica-opciones-compra #ecommerce-ficha-tecnica-modelo"));
        String mm = textoMarcaModelo.getText();

        WebElement textoNombre = driver.findElement(By.cssSelector(".ecommerce-ficha-tecnica-opciones-compra #ecommerce-ficha-tecnica-nombre"));
        String nombreEquipo = textoNombre.getText();

        WebElement textoPrecio = driver.findElement(By.cssSelector(".ecommerce-ficha-tecnica-opciones-compra #ecommerce-ficha-tecnica-precio-obj"));
        String precioEquipo = textoPrecio.getText();
        precioEquipo = precioEquipo.replace(",", "");
        precioEquipo = precioEquipo.replace("$", "");
        double pe = Double.parseDouble(precioEquipo);

        WebElement textoCapacidad = driver.findElement(By.cssSelector(".ecommerce-ficha-tecnica-opciones-compra .ecommerce-ficha-tecnica-opciones-compra-caracteristicas-etiqueta"));
        String capacidadEquipo = textoCapacidad.getText();
        String[] datos = capacidadEquipo.split(" ");
        String capacidadString = datos[0];
        int numGigas = Integer.parseInt(capacidadString);

        if (primerCelular.getMarcaModelo().equals(mm))
            System.out.println("La marca y modelo coinciden");
        else
            System.out.println("La marca y modelo no coincide");

        if (primerCelular.getNombre().equals(nombreEquipo))
            System.out.println("El nombre coincide");
        else
            System.out.println("La marca y modelo no coincide");

        if (primerCelular.getPrecio() == pe)
            System.out.println("El precio coincide");
        else
            System.out.println("El precio no coincide");

        if (primerCelular.getCapacidadGb() == numGigas)
            System.out.println("La capacidad coincide");
        else
            System.out.println("La capacidad no coincide");
    }

/*    public static void cerrarBrowser() {
        driver.quit();
    }*/
}

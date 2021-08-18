import model.item.Articulo;
import model.item.Combo;
import model.item.Item;
import model.store.Store;
import model.store.Ubicacion;

public class Recursos {

    //items
    protected Articulo tv;
    protected Articulo homeTheather;

    protected Combo comboCine;//combo cine = tv + homeTheather

    protected Articulo consola;
    protected Articulo controlConsola;
    protected Articulo juego;
    protected Combo comboJuego;//combo juego = consola+control+juego

    protected Articulo sillon;
    protected Combo comboLiving;//combo Living = combo cine + combo juego + sillon

    protected Articulo heladera;

    protected Articulo notebook;

    protected Articulo valija;

    protected Articulo parlante;

    protected Articulo paletaPadel;
    protected Articulo pelotaDeTenis;
    protected Combo comboPaddle;//combo paddle = pelota + paleta


    protected Articulo mouse;
    protected Articulo teclado;

    protected Combo comboInput; //combo input = mouse + teclado

    protected Articulo auricular;
    protected Articulo pcEscritorio;

    protected Combo comboInputPC;//combo input  + pcEscritorio + auricular

    protected Articulo guitarra;
    protected Articulo amplificador;
    protected Combo comboGuitarrista; //comboguitarrista = guitarra+ amplificador

    protected Articulo bateria;

    protected Articulo bajo;
    protected Combo comboBanda;//combo banda = comboguitarrista + bateria + bajo

    //sucursales
    protected Store sucursalMEdrano;
    protected Store sucursalMozart;

    public void iniciarSucursales(){ //todo
        Ubicacion medrano= new Ubicacion("Av. Medrano 951, C1179 AAQ, Buenos Aires",-34.59859412721525d ,-58.41992119079607d );
        sucursalMEdrano = new Store(1,medrano,"Roberto",4523);

        sucursalMEdrano.agregarArticulo(consola,1);
        sucursalMEdrano.agregarArticulo(homeTheather,1);
        sucursalMEdrano.agregarArticulo(tv,1);
        sucursalMEdrano.agregarArticulo(controlConsola,1);
        sucursalMEdrano.agregarArticulo(sillon,1);

        sucursalMEdrano.agregarArticulo(comboJuego,1);
        sucursalMEdrano.agregarArticulo(comboCine,1);
        sucursalMEdrano.agregarArticulo(comboLiving,1);

        Ubicacion mozart = new Ubicacion("Mozart 2300, C1407 CABA",-34.65927096597888d ,-58.4673399745992d );
        sucursalMozart = new Store(1,mozart,"Juan",345345);
    }

    public void iniciarArticulos(){
        tv = new Articulo("Tele 50\"","Philips ","Smart TV Philips 50\" 4K 50PUD6654 posee: Diseño sin bordes, menos marco, escenas más amplias - Bases delgadas y refinadas, transmiten liviandad - Pixel Precise Ultra HD, movimiento fluido y profundidad visible - Compatible con HDR10+ - Dolby Vision y Dolby Atmos, para imagen y sonido cinematográfico - SAPHI, la forma más inteligente de disfrutar de tu televisor - Acceso con un solo botón a un menú de íconos sencillos- Bluetooth para que puedas conectar tus dispositivos compatibles - Colección Philips TV: Netflix, Prime Video y mucho más - Sonido nítido de parlantes de rango completo - Graves potentes.", 72.999f);
        homeTheather = new Articulo("home Theather","Logitech ","Sistema multicanal",18.613f);

        comboCine = new Combo("Combo cine",25); //combo cine = tv + homeTheather
        comboCine.agregarProducto(tv);
        comboCine.agregarProducto(homeTheather);

        consola = new Articulo("PlayStation 4","sony","entretenimiento asegurado",88.999f);
        controlConsola = new Articulo("Dualshock 4","sony","control",10.397f);
        juego = new Articulo("Uncharted 4","Naughty Dog","para ps4",2.299f);

        comboJuego = new Combo("Combo Juego",15);//combo juego = consola+control+juego
        comboJuego.agregarProducto(consola);
        comboJuego.agregarProducto(controlConsola);
        comboJuego.agregarProducto(juego);

        sillon = new Articulo("Sillon ","Chenille ","comodo",27.399f);

        comboLiving = new Combo("Combo Livinig",10);//combo Living = combo cine + combo juego + sillon
        comboLiving.agregarProducto(comboCine);
        comboLiving.agregarProducto(comboJuego);
        comboLiving.agregarProducto(sillon);

        heladera = new Articulo("Heladera","Gafa ","La heladera Gafa HGF387AFB cuenta con un EXTRA Freezer que permite una mayor capacidad de guardado y mejor organización de los congelados. El espacio para refrigerador cuenta con 254 litros y el freezer tiene un total de 120 litros para congelados. Su interior se encuentra dividida por diferentes compartimentos; crisper de frutas y verduras de acrílico de cristal de alta resistencia, estantes de rejilla removibles, cubetera y huevera. Cuenta con eficiencia energética A. Su sistema de descongelamiento automático facilita la limpieza del refrigerador. Además, su potencia de temperatura puede regularse dependiendo del tipo y cantidad de alimentos que se quieran conservar y la época del año.\n",72.999f);

        notebook = new Articulo("Notebook","acer","Apto para uso en: Hogar, Estudio, Oficina, Trabajo, Gamer",64.999f);

        valija = new Articulo("valija","Wacky","Tamaño Chica",2.800f);

        parlante = new Articulo("parlante","Philips ","Modelo TAS2505B/00",4.399f);


        paletaPadel = new Articulo("paleta de Padel","Davor Patrol","color: negra",9.199f);
        pelotaDeTenis = new Articulo("Pelota De Tenis x3","Penn ","Tipo de pelota: Profesional",1.099f);

        comboPaddle = new Combo("combo paddle",5);//combo paddle = pelota + paleta
        comboPaddle.agregarProducto(paletaPadel);
        comboPaddle.agregarProducto(pelotaDeTenis);

        mouse = new Articulo("Mouse ","Genius","periferico ",399f);
        teclado = new Articulo("Teclado ","Genius","periferico",712f);

        comboInput = new Combo ("Combo input",10);//combo input = mouse + teclado
        comboInput.agregarProducto(mouse);
        comboInput.agregarProducto(teclado);

        auricular = new Articulo("Auriculares ","JBL","Salida de audio",3.895f);
        pcEscritorio = new Articulo("Pc Armada","AMD","AMD",49.999f);

        comboInputPC = new Combo("Combo pc y perifericos",35);//combo input  + pcEscritorio + auricular
        comboInputPC.agregarProducto(comboInput);
        comboInputPC.agregarProducto(pcEscritorio);
        comboInputPC.agregarProducto(auricular);

        guitarra = new Articulo("Guitarra ","Stratocaster ","suena",14.999f);
        amplificador = new Articulo("Amplificador ","Ross ","amplifica sonido",7.800f);

        comboGuitarrista =  new Combo("Combo Guitarrista",5);//comboguitarrista = guitarra+ amplificador
        comboGuitarrista.agregarProducto(guitarra);
        comboGuitarrista.agregarProducto(amplificador);

        bateria= new Articulo("Bateria ","Star ","Diámetro del bombo: 22 in",32.474f);

        bajo= new Articulo("Bajo ","Femmto ","Acabado del cuerpo\tBrillante",17.999f);

        comboBanda = new Combo("Combo Banda",12);//combo banda = comboguitarrista + bateria + bajo
        comboBanda.agregarProducto(comboGuitarrista);
        comboBanda.agregarProducto(bateria);
        comboBanda.agregarProducto(bajo);

    }
}

import apis.locationService.LocationService;
import model.item.Articulo;
import model.item.Combo;
import model.item.Producto;
import model.sucursal.Sucursal;
import model.sucursal.Ubicacion;
import model.user.Administrador;
import model.user.Contacto;
import sesion.Sesion;

import java.util.ArrayList;
import java.util.List;

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


    public List<Producto> articulos; //poner todo aca todos los articulos

    //sucursales
    protected Sucursal sucursalMEdrano;
    protected Sucursal sucursalMozart;

    //Admins
    protected Administrador adminMedrano;
    protected Administrador adminMozrt;

    public void iniciarSucursales(){ //todo
        Ubicacion medrano= new Ubicacion("Av. Medrano 951, C1179 AAQ, Buenos Aires",-34.59859412721525d ,-58.41992119079607d );

        Sesion sesiona= new Sesion(null);

        sesiona.getUsuario().iniciarSesion("adminMedrano","1234");
        adminMedrano = (Administrador) sesiona.getUsuario();

        sucursalMEdrano = new Sucursal(medrano.getDireccion());
        sucursalMEdrano.agregarEncaragado("Todo",adminMedrano);
        sucursalMEdrano.agregarArticulo(consola,4);

        sucursalMEdrano.agregarArticulo(homeTheather,10);
        sucursalMEdrano.agregarArticulo(tv,3);
        sucursalMEdrano.agregarArticulo(controlConsola,1);
        sucursalMEdrano.agregarArticulo(sillon,1);

        sucursalMEdrano.agregarArticulo(comboJuego,3);
        sucursalMEdrano.agregarArticulo(comboCine,1);
        sucursalMEdrano.agregarArticulo(comboLiving,1);

        sesiona.setSucursal(sucursalMEdrano);


        Sesion sesionb= new Sesion(null);

        sesionb.getUsuario().iniciarSesion("adminMozart","1234");
        adminMozrt = (Administrador) sesionb.getUsuario();

        Ubicacion mozart = new Ubicacion("Mozart 2300, C1407 CABA",-34.65927096597888d ,-58.4673399745992d );
        sucursalMozart = new Sucursal(mozart.getDireccion());
        sucursalMozart.agregarEncaragado("Todo",adminMozrt);
        sesionb.setSucursal(sucursalMozart);
        sucursalMEdrano.agregarEncaragado(consola.getNombre(),adminMozrt);
    }

    public void iniciarArticulos(){
        articulos = new ArrayList<>();
        tv = new Articulo(1,"Tele 50\"","Philips ","Smart TV Philips 50\" 4K 50PUD6654 posee: Dise??o sin bordes, menos marco, escenas m??s amplias - Bases delgadas y refinadas, transmiten liviandad - Pixel Precise Ultra HD, movimiento fluido y profundidad visible - Compatible con HDR10+ - Dolby Vision y Dolby Atmos, para imagen y sonido cinematogr??fico - SAPHI, la forma m??s inteligente de disfrutar de tu televisor - Acceso con un solo bot??n a un men?? de ??conos sencillos- Bluetooth para que puedas conectar tus dispositivos compatibles - Colecci??n Philips TV: Netflix, Prime Video y mucho m??s - Sonido n??tido de parlantes de rango completo - Graves potentes.", 72.999f);
        homeTheather = new Articulo(101,"home Theather","Logitech ","Sistema multicanal",40613f);

        comboCine = new Combo(102,"Combo cine",25); //combo cine = tv + homeTheather
        comboCine.agregarProducto(tv);
        comboCine.agregarProducto(homeTheather);

        consola = new Articulo(2,"PlayStation 4","sony","entretenimiento asegurado",88999f);
        controlConsola = new Articulo(103,"Dualshock 4","sony","control",10397f);
        juego = new Articulo(3,"Uncharted 4","Naughty Dog","para ps4",2299f);

        comboJuego = new Combo(104,"Combo Juego",5);//combo juego = consola+control+juego
        comboJuego.agregarProducto(consola);
        comboJuego.agregarProducto(controlConsola);
        comboJuego.agregarProducto(juego);


        sillon = new Articulo(4,"Sillon ","Chenille ","comodo",27399f);

        comboLiving = new Combo(105,"Combo Livinig",10);//combo Living = combo cine + combo juego + sillon
        comboLiving.agregarProducto(comboCine);
        comboLiving.agregarProducto(comboJuego);
        comboLiving.agregarProducto(sillon);


        heladera = new Articulo(5,"Heladera","Gafa ","La heladera Gafa HGF387AFB cuenta con un EXTRA Freezer que permite una mayor capacidad de guardado y mejor organizaci??n de los congelados. El espacio para refrigerador cuenta con 254 litros y el freezer tiene un total de 120 litros para congelados. Su interior se encuentra dividida por diferentes compartimentos; crisper de frutas y verduras de acr??lico de cristal de alta resistencia, estantes de rejilla removibles, cubetera y huevera. Cuenta con eficiencia energ??tica A. Su sistema de descongelamiento autom??tico facilita la limpieza del refrigerador. Adem??s, su potencia de temperatura puede regularse dependiendo del tipo y cantidad de alimentos que se quieran conservar y la ??poca del a??o.\n",72.999f);

        notebook = new Articulo(6,"Notebook","acer","Apto para uso en: Hogar, Estudio, Oficina, Trabajo, Gamer",64999f);

        valija = new Articulo(7,"valija","Wacky","Tama??o Chica",2800f);

        parlante = new Articulo(8,"parlante","Philips ","Modelo TAS2505B/00",4399f);


        paletaPadel = new Articulo(9,"paleta de Padel","Davor Patrol","color: negra",9199f);
        pelotaDeTenis = new Articulo(10,"Pelota De Tenis x3","Penn ","Tipo de pelota: Profesional",1099f);

        comboPaddle = new Combo(106,"combo paddle",5);//combo paddle = pelota + paleta
        comboPaddle.agregarProducto(paletaPadel);
        comboPaddle.agregarProducto(pelotaDeTenis);

        mouse = new Articulo(11,"Mouse ","Genius","periferico ",399f);
        teclado = new Articulo(12,"Teclado ","Genius","periferico",712f);

        comboInput = new Combo (107,"Combo input",10);//combo input = mouse + teclado
        comboInput.agregarProducto(mouse);
        comboInput.agregarProducto(teclado);

        auricular = new Articulo(13,"Auriculares ","JBL","Salida de audio",3895f);
        pcEscritorio = new Articulo(14,"Pc Armada","AMD","AMD",49999f);

        comboInputPC = new Combo(108,"Combo pc y perifericos",35);//combo input  + pcEscritorio + auricular
        comboInputPC.agregarProducto(comboInput);
        comboInputPC.agregarProducto(pcEscritorio);
        comboInputPC.agregarProducto(auricular);

        guitarra = new Articulo(202,"Guitarra ","Stratocaster ","suena",14999f);
        amplificador = new Articulo(15,"Amplificador ","Ross ","amplifica sonido",7800f);

        comboGuitarrista =  new Combo(109,"Combo Guitarrista",5);//comboguitarrista = guitarra+ amplificador
        comboGuitarrista.agregarProducto(guitarra);
        comboGuitarrista.agregarProducto(amplificador);

        bateria= new Articulo(16,"Bateria ","Star ","Di??metro del bombo: 22 in",32474f);

        bajo= new Articulo(17,"Bajo ","Femmto ","Acabado del cuerpo\tBrillante",17999f);

        comboBanda = new Combo(110,"Combo Banda",12);//combo banda = comboguitarrista + bateria + bajo
        comboBanda.agregarProducto(comboGuitarrista);
        comboBanda.agregarProducto(bateria);
        comboBanda.agregarProducto(bajo);


        articulos.add(tv);
        articulos.add(homeTheather);
        articulos.add(comboCine);
        articulos.add(consola);
        articulos.add(controlConsola);
        articulos.add(juego);
        articulos.add(comboJuego);
        articulos.add(sillon);
        articulos.add(comboLiving);
        articulos.add(heladera);
        articulos.add(notebook);
        articulos.add(valija);
        articulos.add(parlante);
        articulos.add(paletaPadel);
        articulos.add(pelotaDeTenis);
        articulos.add(comboPaddle);
        articulos.add(mouse);
        articulos.add(teclado);
        articulos.add(comboInput);
        articulos.add(auricular);
        articulos.add(pcEscritorio);
        articulos.add(comboInputPC);
        articulos.add(guitarra);
        articulos.add(amplificador);
        articulos.add(comboGuitarrista);
        articulos.add(bateria);
        articulos.add(bajo);
        articulos.add(comboBanda);
    }
}

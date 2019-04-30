package componentes;

import java.io.IOException;
import java.io.RandomAccessFile;

public class GeneradorArchivos {

    private static final String[] ESTADOS = {"01Aguascalientes", "02Baja California", "03Baja California Sur", "04Campeche", "05Chiapas", "06Chihuahua", "07Coahuila",
        "08Colima", "09Durango", "10Guanajuato", "11Guerrero", "12Hidalgo", "13Jalisco", "14Mexico", "15Michoacan", "16Morelos",
        "17Nayarit", "18Nuevo Leon", "19Oaxaca", "20Puebla", "21Queretaro", "22Quintana Roo", "23San Luis Potosi", "24Sinaloa",
        "25Sonora", "26Tabasco", "27Tamaulipas", "28Tlaxcala", "29Veracruz", "30Yucatan", "31Zacatecas", "32Ciudad de Mexico"};

    private static final String[] MUNICIPIOS = {"0101aguascalientes", "0102asientos", "0103calvillo", "0104cosio", "0105jesus maria", "0201ensenada", "0202mexicali",
        "0203tecate", "0204tijuana", "0205playas de rosarito", "0301comondu", "0302mulege", "0303la paz", "0304los cabos",
        "0305loreto", "0401calkini", "0402campeche", "0403carmen", "0404champoton", "0405hecelchakan", "0501acacoyagua",
        "0502acala", "0503acapetahua", "0504altamirano", "0505amatan", "0601ahumada", "0602aldama", "0603allende", "0604aquiles serdan",
        "0605chihuahua", "0701abasolo", "0702acuna", "0703allende", "0704arteaga", "0705candela", "0801armeria", "0802colima", "0803comala",
        "0804coquimatlan", "0805cuauhtemoc", "0901canatlan", "0902canelas", "0903coneto de comonfort", "0904cuencame", "0905durango", "1001abasolo",
        "1002acambaro", "1003san miguel de allende", "1004apaseo el alto", "1005apaseo el grande", "1101acapulco de juarez", "1102ahuacuotzingo",
        "1103ajuchitlan del progreso", "1104alcozauca de guerrero", "1105alpoyeca", "1201acatlan", "1202acaxochitlan", "1203actopan", "1204agua blanca de iturbide",
        "1205ajacuba", "1301Guadalajara", "1302acatlan de juarez", "1303ahualulco de mercado", "1304amacueca", "1305chapala", "1401acambay de ruiz castaneda", "1402acolman",
        "1403aculco", "1404almoloya de alquisiras", "1405almoloya de juarez", "1501acuitzio", "1502aguililla", "1503alvaro obregon", "1504angamacutiro", "1505angangueo",
        "1601amacuzac", "1602atlatlahucan", "1603axochiapan", "1604ayala", "1605coatlan del rio", "1701acaponeta", "1702ahuacatlan", "1703ixtlan del rio", "1704tecuala",
        "1705tepic", "1801abasolo", "1802agualeguas", "1803los aldamas", "1804allende", "1805monterrey", "1901abejones", "1902acatlan de perez figueroa",
        "1903asuncion cacalotepec", "1904cosolapa", "1905cosoltepec", "2001acajete", "2002acateno", "2003acatlan", "2004acatzingo", "2005acteopan", "2101amealco de bonfil",
        "2102pinal de amoles", "2103arroyo seco", "2104cadereyta de montes", "2105colon", "2201cozumel", "2202felipe carrillo puerto", "2203isla mujeres", "2204Qintanarro4",
        "2205Qintanarro5", "2301ahualulco", "2302alaquines", "2303aquismon", "2304armadillo de los infante", "2304San luis potosi", "2401Cosala", "2402Culiacan", "2405Guasave",
        "2414Mazatlan", "2415Navolato", "2501aconchi", "2502agua prieta", "2503alamos", "2504altar", "2505hermosillo", "2601balancan", "2602cardenas", "2603centla", "2604Tabasco4",
        "2605Tabasco5", "2701abasolo", "2702aldama", "2703altamira", "2704antiguo morelos", "2705burgos", "2801amaxac de guerrero", "2802apetatitlan de antonio carvajal", "2803atlangatepec",
        "2804atltzayanca", "2805calpulalpan", "2901acajete", "2902acatlan", "2903acayucan", "2904Veracruz4", "2905Veracruz5", "3001abala", "3002acanceh", "3003akil", "3004baca", "3005bokoba",
        "3101apozol", "3102apulco", "3103atolinga", "3104benito juarez", "3105calera", "3201coyoacan", "3202xochimilco", "3203iztapalapa", "3204alvaro obregon", "3205tlalpan"};

    private RandomAccessFile estados, municipios, ciudades;

    private GeneradorArchivos() {
        try {
            estados = new RandomAccessFile("ESTADOS.dat", "rw");
            municipios = new RandomAccessFile("MUNICIPIOS.dat", "rw");
            ciudades = new RandomAccessFile("CIUDADES.dat", "rw");
        } catch (Exception e) {
            e.printStackTrace();
        }

        llenarEstados();
        llenarMunicipios();
        llenarCiudades_();
        imprimirArchivos();
    }

    public static void main(String[] args) {
        new GeneradorArchivos();
    }

    private void llenarEstados() {
        try {
            for (int i = 0; i < ESTADOS.length; i++) {
                estados.writeUTF(ESTADOS[i].substring(0, 2));
                estados.writeUTF(PonBlancos(ESTADOS[i].substring(2), 50));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void llenarMunicipios() {
        try {
            for (int i = 0; i < MUNICIPIOS.length; i++) {
                municipios.writeUTF(MUNICIPIOS[i].substring(0, 2));
                municipios.writeUTF(MUNICIPIOS[i].substring(2, 4));
                municipios.writeUTF(PonBlancos(MUNICIPIOS[i].substring(4), 50));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void llenarCiudades_() {
        try {
            for (int i = 0; i < MUNICIPIOS.length; i++) {
                for (int j = 1; j <= 5; j++) {
                    ciudades.writeUTF(MUNICIPIOS[i].substring(0, 2));
                    ciudades.writeUTF(MUNICIPIOS[i].substring(2, 4));
                    ciudades.writeUTF("0" + (j + ""));
                    ciudades.writeUTF(PonBlancos("Cd "+MUNICIPIOS[i].substring(4,7), 6)+(j+""));
//                    ciudades.writeUTF(PonBlancos("Cd"+ MUNICIPIOS[i].toUpperCase().charAt(4) + MUNICIPIOS[i].substring(5,7), 5)+(j+" "));

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static public String PonBlancos(String Texto, int Tamano) {
        while (Texto.length() < Tamano) {
            Texto += " ";
        }
        return Texto;
    }

    static public String PonCeros(String Texto, int Tamano) {
        while (Texto.length() < Tamano) {
            Texto = "0" + Texto;
        }
        return Texto;
    }

    private void imprimirArchivos() {
        try {
            int nEstados = (int) (estados.length() / 56),
                    nMunicipios = (int) (municipios.length() / 60),
                    nCiudades = (int) (ciudades.length() / 21);

            System.out.println(nEstados + " " + nMunicipios + " " + nCiudades);

            estados.seek(0);
            municipios.seek(0);
            ciudades.seek(0);

            for (int i = 0; i < nEstados; i++) {
                System.out.println(estados.readUTF() + " " + estados.readUTF());
            }

            System.out.println("\n________________________________________________");

            for (int i = 0; i < nMunicipios; i++) {
                System.out.println(municipios.readUTF() + " " + municipios.readUTF() + " " + municipios.readUTF());
            }

            System.out.println("\n________________________________________________");

            for (int i = 0; i < nCiudades; i++) {
                System.out.println(ciudades.readUTF() + " " + ciudades.readUTF() + " " + ciudades.readUTF() + " " + ciudades.readUTF());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

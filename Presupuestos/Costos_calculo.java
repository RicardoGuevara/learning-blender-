public class Costos_calculo
{
    static public void main(String [] args) throws java.io.IOException
    {
        java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader("materiales_general/general"));
        String txt;
        while((txt = reader.readLine())!=null)
        {
            if(!txt.startsWith("/"))Articulo.add(new Articulo(txt));
        }
        System.out.println(Articulo.total);
    }
}

class Articulo
{
    public Articulo(String str)
    {
        this.nombre = str.substring(0,str.indexOf("|"));
        str = str.substring(str.indexOf("|")+1);
        this.cantidad = Integer.parseInt(str.substring(0,str.indexOf("|")));
        str = str.substring(str.indexOf("|")+1);
        this.unidad = str.substring(0,str.indexOf("|"));
        str = str.substring(str.indexOf("|")+1);
        this.precio = Integer.parseInt(str.substring(0,str.indexOf("|")));
        str = str.substring(str.indexOf("|")+1);
        this.URL = str;
    }
    
    static public void add(Articulo a)
    {
        total += a.precio * a.cantidad;
    }
    
    static public float total=0;
    String  nombre,
            unidad,
            URL;
    float   precio,
            cantidad;
}
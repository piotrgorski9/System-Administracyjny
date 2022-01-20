public class Pracownik {

    private String imie;
    private String nazwisko;
    private int rok_Urodzenia;
    private String dzial;
    private int wyplata;

    public Pracownik(){

    }

    public Pracownik(String imie, String nazwisko, int rok_Urodzenia, String dzial, int wyplata){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.rok_Urodzenia = rok_Urodzenia;
        this.dzial = dzial;
        this.wyplata = wyplata;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getRok_Urodzenia() {
        return rok_Urodzenia;
    }

    public void setRok_Urodzenia(int rokUrodzenia) {
        this.rok_Urodzenia = rokUrodzenia;
    }

    public String getDzial() {
        return dzial;
    }

    public void setDzial(String dzial) {
        this.dzial = dzial;
    }

    public int getWyplata() {
        return wyplata;
    }

    public void setWyplata(int wyplata) {
        this.wyplata = wyplata;
    }

    public String toString(){
        String str = new String(imie + " " + nazwisko + "; Rok Urodzenia: " + rok_Urodzenia + "; Dzial: " + dzial + "; Wysokość wyplaty: " + wyplata);
        return str;
    }
}

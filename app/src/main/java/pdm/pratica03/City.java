package pdm.pratica03;

public class City {
    private String name;
    private String weather; // Agora "info" foi alterado para "weather" e é inicializado com null

    public City(String name) {
        this.name = name;
        this.weather = null; // Inicializando o atributo "weather" com null
    }

    // Getter para o nome da cidade
    public String getName() {
        return name;
    }

    // Getter para a informação climática (weather)
    public String getWeather() {
        return weather;
    }

    // Setter para a informação climática (weather)
    public void setWeather(String weather) {
        this.weather = weather;
    }
}

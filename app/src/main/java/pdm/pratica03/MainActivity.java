package pdm.pratica03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    public static final City [] cities = {
            new City("Recife"),
            new City("João Pessoa"),
            new City("Natal"),
            new City("Fortaleza"),
            new City("Salvador"),
            new City("São Luiz"),
            new City("Teresina"),
            new City("Rio de Janeiro"),
            new City("São Paulo"),
            new City("Vitória"),
            new City("Belo Horizonte"),
            new City("Florianópolis"),
            new City("Curitiba"),
            new City("Porto Alegre"),
            new City("Macapá"),
            new City("Porto Velho"),
            new City("Palmas"),
            new City("Boa Vista"),
            new City("Belém"),
            new City("Rio Branco"),
            new City("Manaus"),
            new City("Goiania"),
            new City("Cuiabá"),
            new City("Campo Grande")
    };

    private RequestQueue queue; // Declare a variável "queue" aqui

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.queue = Volley.newRequestQueue(this);

        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(new CityAdapter(this, queue,
                R.layout.city_listitem, cities));

        listView.setOnItemClickListener((parent, view, position, id) ->
                Toast.makeText(parent.getContext(), "Cidade selecionada: " +
                        cities[position].getName(), Toast.LENGTH_SHORT).show());
    }

    @Override
    public void onStop() {
        super.onStop();
        queue.cancelAll(this);
    }

    private String getWeather(JSONObject forecastJson) {
        final String OWM_WEATHER = "weather";
        final String OWM_TEMPERATURE = "temp";
        final String OWM_MAIN = "main";
        final String OWM_DESCRIPTION = "description";
        try {
            JSONObject weatherObject = forecastJson.getJSONArray(OWM_WEATHER).
                    getJSONObject(0);
            JSONObject mainObject = forecastJson.getJSONObject(OWM_MAIN);
            String description = weatherObject.getString(OWM_DESCRIPTION);
            double temp = mainObject.getDouble(OWM_TEMPERATURE);
            return description + " - " + temp;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }



}

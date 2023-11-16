import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.sun.tools.javac.Main;

public class BdUsuario {
     public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        Usuario user = new Usuario("henrique", "56", "4", "masc", "ad@", 0, 0);

        FileWriter writerFile = null;

        try {
            // Salva o usuário como um objeto JSON em um arquivo
            writerFile = new FileWriter("dados_usuario1.json");
            jsonObject.put("nome", user.getNome());
            jsonObject.put("cpf", user.getCpf());
            jsonObject.put("senha", user.getSenha());
            jsonObject.put("sexo", user.getSexo());
            jsonObject.put("email", user.getEmail());
            jsonObject.put("idade", user.getIdade());
            jsonObject.put("nivel", user.getNivel());

            writerFile.write(jsonObject.toJSONString());
            writerFile.close();
            System.out.println("Usuário salvo como JSON: " + user.toString());

            // Lê o objeto JSON do arquivo e converte para um objeto Usuario
            JSONParser parser = new JSONParser();
            JSONObject objetoJson = (JSONObject) parser.parse(new FileReader("dados_usuario1.json"));

            Usuario usuarioLido = new Usuario();
            usuarioLido.setNome((String) objetoJson.get("nome"));
            usuarioLido.setCpf((String) objetoJson.get("cpf"));
            usuarioLido.setSenha((String) objetoJson.get("senha"));
            usuarioLido.setSexo((String) objetoJson.get("sexo"));
            usuarioLido.setEmail((String) objetoJson.get("email"));
            usuarioLido.setIdade(((Long) objetoJson.get("idade")).intValue());
            usuarioLido.setNivel(((Long) objetoJson.get("nivel")).intValue());

            System.out.println("Usuário lido do JSON: " + usuarioLido.toString());

        } catch (IOException | org.json.simple.parser.ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (writerFile != null) {
                    writerFile.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
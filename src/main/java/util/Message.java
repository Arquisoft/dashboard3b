package util;

import com.google.gson.Gson;

import model.Comentario;
import model.Sugerencia;
import model.VotoComentario;
import model.VotoSugerencia;

public class Message {
	
	public static final Gson gson = new Gson();

    public static String getMessage(Sugerencia sugerencia) {
        return gson.toJson(sugerencia);
    }
    
    public static String setMessage(Comentario comentario) {
    	return gson.toJson(comentario);
    }
    
    public static String setMessage(VotoComentario votoComentario) {
    	return gson.toJson(votoComentario);
    }
    
    public static String setMessage(VotoSugerencia votoSusgerencia) {
    	return gson.toJson(votoSusgerencia);
    }

}

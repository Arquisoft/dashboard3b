package dashboard.kafka.listeners;

import javax.annotation.ManagedBean;

import model.Sugerencia;

import org.apache.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;

import dashboard.kafka.Message;

/**
 * Created by herminio on 28/12/16.
 */
@ManagedBean
public class MessageListener {

    private static final Logger logger = Logger.getLogger(MessageListener.class);

    @KafkaListener(topics = "exampleTopic")
    public void listen(String data) {
        logger.info("New message received: \"" + data + "\"");
    }
    
    @KafkaListener(topics = "CREATE_SUGGESTION")
    public void createSuggestion(String data) {
    	Sugerencia sugg = Message.getSugerenciaFromJSON(data);
        logger.info("New message received: [CREAR SUGERENCIA]  \"" +  data + "\"");
        
        logger.info("[CREAR SUGERENCIA] Autor de la accion [id="+sugg.getCitizen().getId()+"] " + sugg.getCitizen().getNombre() + 
        		"  [id=" + sugg.getId() + "] " + sugg.getTitulo());
    }
    
    

//	public final static String CREATE_SUGGESTION = "CREATE_SUGGESTION";
//	public final static String DELETE_SUGGESTION ="DELETE_SUGGESTION";
//	public final static String VOTE_SUGGESTION_POSITIVE = "VOTE_SUGGESTION_POSITIVE";
//	public final static String VOTE_SUGGESTION_NEGATIVE = "VOTE_SUGGESTION_NEGATIVE";
//	
//	public final static String COMMENT_SUGGESTION = "COMMENT_SUGGESTION";
//	public final static String DELETE_COMMENT = "DELETE_COMMENT";
//	public final static String VOTE_COMMENT = "VOTE_COMMENT";

}

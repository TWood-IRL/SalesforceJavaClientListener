
	import org.cometd.bayeux.Message;
	import org.cometd.bayeux.client.ClientSessionChannel;

	import java.text.SimpleDateFormat;
	import java.util.Date;
 
public class SaleforceListener 
	implements ClientSessionChannel.MessageListener {

	    private boolean logSuccess;
	    private boolean logFailure;

	    public SaleforceListener() {
	        this.logSuccess = true;
	        this.logFailure = true;
	    }

	    public SaleforceListener(boolean logSuccess, boolean logFailure) {
	        this.logSuccess = logSuccess;
	        this.logFailure = logFailure;
	    }

	    @Override
	    public void onMessage(ClientSessionChannel clientSessionChannel, Message message) {
	        if (logSuccess && message.isSuccessful()) {
	            System.out.println(">>>>");
	            printPrefix();
	            System.out.println("Success:[" + clientSessionChannel.getId() + "]");
	            System.out.println(message);
	            System.out.println("<<<<");
	        }

	        if (logFailure && !message.isSuccessful()) {
	            System.out.println(">>>>");
	            printPrefix();
	            System.out.println("Failure:[" + clientSessionChannel.getId() + "]");
	            System.out.println(message);
	            System.out.println("<<<<");
	        }
	    }

	    private void printPrefix() {
	        System.out.print("[" + timeNow() + "] ");
	    }

	    private String timeNow() {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	        Date now = new Date();
	        return dateFormat.format(now);
	    }
	}


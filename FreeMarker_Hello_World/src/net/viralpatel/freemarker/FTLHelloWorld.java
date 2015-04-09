package net.viralpatel.freemarker;
 
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//import java.util.Map;
 
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
 
public class FTLHelloWorld {
    
	/**
	 * @method main
	 * @param args
	 */
    public static void main(String[] args) {
         
        // Freemarker configuration object
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
        try {
        	cfg.setDirectoryForTemplateLoading(new File(".\\src"));
        	cfg.setDefaultEncoding("UTF-8");

            //Load template from source folder
            Template template = cfg.getTemplate("helloworld.ftl");
             
            // Build the data-model
            HashMap<String, Object> data = new HashMap<>();
            //Map<string, object=""> data = new HashMap<string, object="">();
            data.put("message", "Hello World!");
 
            //List parsing
            List<String> countries = new ArrayList<String>();
            countries.add("India");
            countries.add("United States");
            countries.add("Germany");
            countries.add("France");
             
            data.put("countries", countries);
 
             
            // Console output
            Writer out = new OutputStreamWriter(System.out);
            template.process(data, out);
            out.flush();
 
            // File output
            Writer file = new FileWriter (new File(".\\src\\FTL_helloworld.txt"));
            template.process(data, file);
            file.flush();
            file.close();
             
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}

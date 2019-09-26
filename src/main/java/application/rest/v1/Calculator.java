package application.rest.v1;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.ArrayList;


@Path("v1/calculator/{a}/{b}/{op}")
public class Calculator {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
    public Response calculate(String a, String b, String op)
    {
        int numA = Integer.parseInt(a);
        int numB = Integer.parseInt(b);

        switch(op)
        {
            case "+":
                return Response.ok(a + "+" + b + "=" + (Integer.toString((numA + numB)))).build();

            case "-":
                return Response.ok(a + "-" + b + "=" + (Integer.toString((numA - numB)))).build();

            case "*":
                return Response.ok(a + "*" + b + "=" + (Integer.toString((numA * numB)))).build();
            
            case "div":
                if(numB == 0 || b.equals("0"))
                {
                    return Response.ok("Cannot Divide by 0.").build();
                }
                if((numA == 0 && numB == 0))
                {
                    return Response.ok("Undefined. Cannot divide 0 by 0").build();
                }
                else
                {
                    return Response.ok(a + "/" + b + "=" + (Integer.toString((numA / numB)))).build();
                }
            
            case "%":
            {
                return Response.ok(a + "%" + b + "=" + (Integer.toString((numA % numB)))).build();
            }

            case "pow":
            {
                double floatA = Float.parseFloat(a);
                double floatB = Float.parseFloat(b);
                double res = Math.pow(floatA, floatB);
                return Response.ok(a + "^" + b + "=" + (Double.toString(res))).build(); 
            }

            case "hex":
            {
                return Response.ok(a + "in hexadecimal is: " + Integer.toHexString(numA) + " | " + b + " in hex is: " + Integer.toHexString(numB)).build();
            }
            
            case "bin":
            {
                return Response.ok(a + " in binary is: " + Integer.toBinaryString(numA) + " | " + b + " in binary is: " + Integer.toBinaryString(numB)).build();
            }
            default:
            	return Response.ok("Invalid operation. Please Try again").build();
        }
    }
}

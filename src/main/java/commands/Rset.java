package commands;

import model.POP3Connection;
import model.POP3ConnectionException;

import static commands.CommandCreator.createCommand;

public class Rset implements Command {
    @Override
    public String execute(String parameters, POP3Connection connection) throws POP3ClientException {
        try{
            String command = createCommand(CommandName.RSET);
            connection.sendCommand(command);

            return connection.getResponse();
        }
        catch(POP3ConnectionException e){
            throw new POP3ClientException(e.getMessage());
        }
    }
}
package contacts.services;

import contacts.services.actions.Action;
import contacts.services.actions.ActionGetAll;
import contacts.services.actions.ActionHome;

public class ActionFactory {

	public static Action getAction(String cde) {
		Action action = null;
		
		if(cde==null || cde.isEmpty())
			cde = "home";
		switch (cde) {
		case "home":
			action = new ActionHome();
			break;
		case "getAll":
			action = new ActionGetAll();
			break;
		default:
			break;
		}
		return action;
	}
	
}

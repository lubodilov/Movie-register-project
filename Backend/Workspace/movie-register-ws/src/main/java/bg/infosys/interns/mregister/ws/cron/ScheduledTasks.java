package bg.infosys.interns.mregister.ws.cron;

//import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import bg.infosys.interns.mregister.ws.dto.ActorDTO;
import bg.infosys.interns.mregister.ws.service.ActorService;
import bg.infosys.interns.mregister.ws.util.ActorUtil;

@Component
public class ScheduledTasks {
	private final ActorService actorService;
	
	public ScheduledTasks (ActorService actorService) {
		this.actorService = actorService;
	}
	
	public void generateActor() {
		System.out.println("Created new Actor");
		ActorDTO newActor = ActorUtil.generateActor();
		actorService.save(newActor);
	}
}
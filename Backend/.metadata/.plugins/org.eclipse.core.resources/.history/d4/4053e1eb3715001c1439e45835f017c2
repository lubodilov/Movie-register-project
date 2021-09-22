package bg.infosys.interns.mregister.ws.util;

import java.util.Date;
import java.util.Random;

import bg.infosys.interns.mregister.ws.dto.ActorDTO;
import bg.infosys.interns.mregister.ws.dto.CountryDTO;
import bg.infosys.interns.mregister.ws.dto.LocationDTO;
import bg.infosys.interns.mregister.ws.dto.OrganizationDTO;

public class ActorUtil {
	private static Random rand = new Random();
	
	private ActorUtil() {
		throw new IllegalStateException("Utility class");
	}
	
	public static ActorDTO generateActor() {
		ActorDTO dto = new ActorDTO();
		
		//dto.setId(Math.abs(rand.nextLong()%100000));
		dto.setName(generateActorName());
		dto.setIsActive(rand.nextBoolean());
		//dto.setDateOfBirth(generateDate());
		dto.setLocation(generateLocation());
		dto.setOrganization(generateOrganization());		
		return dto;
	}

	private static String generateActorName() {
		return ActorNames.FIRST_NAME[rand.nextInt(ActorNames.FIRST_NAME.length)] + " " +
				ActorNames.LAST_NAME[rand.nextInt(ActorNames.LAST_NAME.length)];
	}
	
	private static CountryDTO generateCountry() {
		CountryDTO country = new CountryDTO();
		country.setName(LocationNames.COUNTRY[rand.nextInt(LocationNames.COUNTRY.length)]);
		country.setCode(LocationNames.CODE[rand.nextInt(LocationNames.CODE.length)]);
		 return country;
	}
	
	private static LocationDTO generateLocation() {
		LocationDTO location = new LocationDTO();
		location.setAddress(LocationNames.ADDRESS[rand.nextInt(LocationNames.ADDRESS.length)]);
		location.setCountry(generateCountry());
		 return location;
	}
	
	private static OrganizationDTO generateOrganization() {
		OrganizationDTO organization = new OrganizationDTO();
		int index = rand.nextInt(OrganizationNames.NAME.length);
		organization.setName(OrganizationNames.NAME[index]);
		organization.setAbbreviation(OrganizationNames.ABBREVIATION[index]);
		organization.setFoundation(generateDate());
		organization.setLocation(generateLocation());
		 return organization;
	}

	private static Date generateDate() {
        int year = randBetween(1950, 2003);
        int dayOfYear = randBetween(1, 365);
        
        Date date = new Date(dayOfYear, year, dayOfYear);
        
        return date;
    }

    private static int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }
}
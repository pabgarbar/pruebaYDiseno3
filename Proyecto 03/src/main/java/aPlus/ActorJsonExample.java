
package aPlus;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import utilities.internal.SchemaPrinter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import domain.Actor;
import domain.Box;
import domain.Message;
import domain.Priority;
import domain.SocialProfile;

public class ActorJsonExample {

	public static void main(final String[] args) {
		final Actor actor = ActorJsonExample.createDummyObject();

		final Gson gson = new GsonBuilder().setPrettyPrinting().create();
		final String json = gson.toJson(actor);

		System.out.println("CREATING JSON FROM ACTOR:");
		System.out.println(json);

		try (FileWriter writer = new FileWriter(new File("Actor.json"))) {
			writer.write(json);
		} catch (final IOException e) {
			e.printStackTrace();
		}
		System.out.println("CREATING ACTOR FROM JSON");

		try (Reader reader = new FileReader("Actor.json")) {
			final Actor actorFJson = gson.fromJson(reader, Actor.class);
			SchemaPrinter.print(actorFJson);
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	private static Actor createDummyObject() {
		final Actor actor = new Actor();

		//Tags
		final List<String> tags = new ArrayList<>();
		tags.add("tag 1");
		tags.add("tag 2");

		final SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
		//Date
		Date d1 = null;
		try {
			d1 = sdf.parse("16/10/12");
		} catch (final ParseException e) {
			e.printStackTrace();
		}

		Date d2 = null;
		try {
			d2 = sdf.parse("16/01/12");
		} catch (final ParseException e) {
			e.printStackTrace();
		}

		//Boxes
		final List<Box> boxes = new ArrayList<>();
		final Box box1 = new Box();
		box1.setFatherBox(null);
		box1.setId(1);
		box1.setIsSystem(true);
		box1.setMessages(null);
		boxes.add(box1);

		final Box box2 = new Box();
		box2.setFatherBox(box1);
		box2.setId(2);
		box2.setIsSystem(false);
		box2.setMessages(null);
		boxes.add(box2);

		//Message's actor
		final List<Actor> receiversActor = new ArrayList<>();
		final Actor receiver1 = new Actor();
		receiver1.setAddress("address1");
		receiver1.setBoxes(boxes);
		receiver1.setEmail("email1@example.com");
		receiver1.setId(1);
		receiver1.setMiddleName("middlename1");
		receiver1.setName("name1");
		receiver1.setPhoneNumber("+34987654321");
		receiver1.setPhoto("https://www.photolink.com");
		receiver1.setSocialProfiles(null);
		receiver1.setSurname("surname1");
		receiver1.setVersion(0);
		receiversActor.add(receiver1);

		final Actor receiver2 = new Actor();
		receiver2.setAddress("address2");
		receiver2.setBoxes(boxes);
		receiver2.setEmail("email2@example.com");
		receiver2.setId(2);
		receiver2.setMiddleName("middlename2");
		receiver2.setName("name2");
		receiver2.setPhoneNumber("+34987654321");
		receiver2.setPhoto("https://www.photolink2.com");
		receiver2.setSocialProfiles(null);
		receiver2.setSurname("surname2");
		receiver2.setVersion(0);
		receiversActor.add(receiver2);

		final List<Actor> receiversActor2 = new ArrayList<>();
		final Actor receiver3 = new Actor();
		receiver3.setAddress("address3");
		receiver3.setBoxes(boxes);
		receiver3.setEmail("email3@example.com");
		receiver3.setId(3);
		receiver3.setMiddleName("middlename3");
		receiver3.setName("name3");
		receiver3.setPhoneNumber("+34987654321");
		receiver3.setPhoto("https://www.photolink3.com");
		receiver3.setSocialProfiles(null);
		receiver3.setSurname("surname3");
		receiver3.setVersion(0);
		receiversActor2.add(receiver3);

		final Actor receiver4 = new Actor();
		receiver4.setAddress("address4");
		receiver4.setBoxes(boxes);
		receiver4.setEmail("email4@example.com");
		receiver4.setId(4);
		receiver4.setMiddleName("middlename4");
		receiver4.setName("name4");
		receiver4.setPhoneNumber("+34987654321");
		receiver4.setPhoto("https://www.photolink4.com");
		receiver4.setSocialProfiles(null);
		receiver4.setSurname("surname4");
		receiver4.setVersion(0);
		receiversActor2.add(receiver4);

		//Messages
		final List<Message> messages = new ArrayList<>();
		final Message message1 = new Message();
		final Message message2 = new Message();

		message1.setBody("body1");
		message1.setMoment(d1);
		message1.setPriority(Priority.HIGH);
		message1.setSender(actor);
		message1.setReceivers(receiversActor);
		message1.setSubject("subject1");
		message1.setTags(tags);
		messages.add(message1);

		message2.setBody("body2");
		message2.setMoment(d2);
		message2.setPriority(Priority.LOW);
		message2.setReceivers(receiversActor2);
		message2.setSender(actor);
		message2.setSubject("subject2");
		message2.setTags(tags);

		//Social Profiles
		final List<SocialProfile> socialProfiles = new ArrayList<>();
		final SocialProfile socialProfile1 = new SocialProfile();
		final SocialProfile socialProfile2 = new SocialProfile();

		socialProfile1.setId(1);
		socialProfile1.setName("Social Profile 1");
		socialProfile1.setNick("nick1");
		socialProfile1.setProfileLink("https://www.profileLink1.com");
		socialProfile1.setVersion(1);
		socialProfiles.add(socialProfile1);

		socialProfile2.setId(2);
		socialProfile2.setName("Social Profile 2");
		socialProfile2.setNick("nick2");
		socialProfile2.setProfileLink("https://www.profileLink2.com");
		socialProfile2.setVersion(2);
		socialProfiles.add(socialProfile2);

		//Actor
		actor.setName("Manuel");
		actor.setMiddleName("Jesús");
		actor.setSurname("Rodríguez");
		actor.setPhoto("http://www.photo.com");
		actor.setEmail("pacorodriguez@.us.es");
		actor.setPhoneNumber("684351974");
		actor.setAddress("Avda. Reina Mercedes Nº8");
		actor.setSocialProfiles(socialProfiles);
		actor.setBoxes(boxes);

		return actor;
	}
}

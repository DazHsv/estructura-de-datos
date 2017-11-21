/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hugosv.olympic_administrator.services;

import me.hugosv.olympic_administrator.vo.BestUniversity;
import me.hugosv.olympic_administrator.vo.Participant;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Hugo Sanchez
 */
public class OlympicControlServiceTest {

	private final Logger logger = Logger.getLogger(OlympicControlServiceTest.class);

	private OlympicControlService target;

	public OlympicControlServiceTest() {
		this.target = new OlympicControlService();
	}

	@Before
	public void setUp() {
		logger.info("SETUP");
		this.target.addParticipant(
			new Participant("Maria Lara Vazquez", "UTCV", "Sincronizado", 200));
		this.target.addParticipant(
			new Participant("Daniel Perez Perez", "UTCV", "Dual", 140));
		
		this.target.addParticipant(
			new Participant("Hugo Sanchez Velazquez", "ITO", "Sincronizado", 200));
		this.target.addParticipant(
			new Participant("Marcos Perez Perez", "ITO", "Mariposa", 240));
		
		this.target.addParticipant(
			new Participant("Marcelo Perez Perez", "UV", "Mariposa", 104));
		this.target.addParticipant(
			new Participant("Javier Perez Perez", "UV", "Dual", 104));
	}

	/**
	 * Test of bestParticipantsBySwimStyle method, of class
	 * OlympicControlService.
	 */
	@Test
	public void testBestParticipantsBySwimStyle() {
		logger.info("TEST: testBestParticipantsBySwimStyle");
		this.target.bestParticipantsBySwimStyle()
			.forEach((String ss, Participant p) -> {
				System.out.println("Swimming style: " + ss);
				System.out.println(p);
			});
	}

	/**
	 * Test of getParticipantByName method, of class OlympicControlService.
	 */
	@Test
	public void testGetParticipantByName() {
		logger.info("TEST: testGetParticipantByName");
		this.target.getParticipantByName("Hugo Sanchez Velazquez")
			.forEach(System.out::println);
	}

	/**
	 * Test of addParticipant method, of class OlympicControlService.
	 */
	@Test
	public void testAddParticipant() {
		// Tested on setUp
	}

	/**
	 * Test of participantsByUniversity method, of class OlympicControlService.
	 */
	@Test
	public void testParticipantsByUniversity() {
		logger.info("TEST: testParticipantsByUniversity");
		this.target.participantsByUniversity("ITO")
			.forEach(System.out::println);
	}

	/**
	 * Test of participantsBySwimStyle method, of class OlympicControlService.
	 */
	@Test
	public void testParticipantsBySwimStyle() {
		logger.info("TEST: testParticipantsBySwimStyle");
		this.target.participantsBySwimStyle("Sincronizado")
			.forEach(System.out::println);
	}

	/**
	 * Test of bestUniversityByTime method, of class OlympicControlService.
	 */
	@Test
	public void testBestUniversityByTime() {
		logger.info("TEST: testBestUniversityByTime");
		BestUniversity bu = this.target.bestUniversityByTime();
		System.out.println(bu);
	}
}

package biblioteka;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import biblioteka.interfejs.BibliotekaInterfejsTest;

public class BibliotekaTest extends BibliotekaInterfejsTest{

	@BeforeEach
	void setUp() throws Exception {
		bibliotekaInterfejs = new Biblioteka();
	}

	@AfterEach
	void tearDown() throws Exception {
		bibliotekaInterfejs = null;
	}
}

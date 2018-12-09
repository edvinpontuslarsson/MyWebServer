package se.lnu.http.integration;

import java.net.Socket;
import org.junit.Test;

import static org.junit.Assert.*;

import se.lnu.http.client.HTTPGetProtocoll;
import se.lnu.http.client.SocketClient;


public class SocketClientTest {

	@Test
	public void testContainsHTTP200OK() throws Exception {
		SocketClient sut = new SocketClient(new Socket(), new HTTPGetProtocoll());
		String actual = sut.get("localhost", 9000, "index.html");

		System.out.println(actual);

		String expected = "HTTP/1.1 200 OK\r\n";
		assertTrue(actual.contains(expected));
	}

	@Test
	public void testContainsDate() throws Exception {
		SocketClient sut = new SocketClient(new Socket(), new HTTPGetProtocoll());
		String actual = sut.get("127.0.0.1", 9000, "index.html");

		String expected = "Date: ";
		assertTrue(actual.contains(expected));
	}

	@Test
	public void testContainsServerInfo() throws Exception {
		SocketClient sut = new SocketClient(new Socket(), new HTTPGetProtocoll());
		String actual = sut.get("127.0.0.1", 9000, "index.html");

		String expected = "Server: Apache/2.2.17 (Win32) mod_wsgi/3.3 Python/2.6.6\r\n";
		assertTrue(actual.contains(expected));
	}

	@Test
	public void testContainsAcceptRanges() throws Exception {
		SocketClient sut = new SocketClient(new Socket(), new HTTPGetProtocoll());
		String actual = sut.get("127.0.0.1", 9000, "index.html");

		String expected = "Accept-Ranges: bytes\r\n";
		assertTrue(actual.contains(expected));
	}

	@Test
	public void testContainsContentLength() throws Exception {
		SocketClient sut = new SocketClient(new Socket(), new HTTPGetProtocoll());
		String actual = sut.get("127.0.0.1", 9000, "index.html");

		String expected = "Content-Length: 44\r\n";
		assertTrue(actual.contains(expected));
	}

	@Test
	public void testContainsContentType() throws Exception {
		SocketClient sut = new SocketClient(new Socket(), new HTTPGetProtocoll());
		String actual = sut.get("127.0.0.1", 9000, "index.html");

		String expected = "Content-Type: text/html\r\n";
		assertTrue(actual.contains(expected));
	}

	@Test
	public void testContainsProperEnding() throws Exception {
		SocketClient sut = new SocketClient(new Socket(), new HTTPGetProtocoll());
		String actual = sut.get("127.0.0.1", 9000, "index.html");

		String expected = "\r\n";
		assertTrue(actual.contains(expected));
	}

}

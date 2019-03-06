package de.cau.infprogoo.lighthouse;

import java.io.IOException;

public class LighthouseView implements View {

	LighthouseDisplay display;

	public LighthouseView(String username, String token) {
		this.display = new LighthouseDisplay(username, token);
	}

	public void connect() {
		try {
			display.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(Model world) {
		byte[] nextFrame = getnextFrame(world);
		try {
			display.send(nextFrame);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private byte[] getnextFrame(Model world) {

		byte[] test = new byte[1176];

		coloringRed(world, test);
		coloringBlue(world, test);
		coloringGreen(world, test);
		coloringYellow(world, test);
		coloringTurquoise(world, test);
		coloringFrame(world, test);

		return test;

	}

	

	private byte[] coloringFrame(Model world, byte[] test) {

		for (int i = 0; i < 28; i++) {
			test[i * 3] = (byte) 120;
			test[i * 3 + 3 * 28 * 13] = (byte) 120;
		}

		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 4; j++) {
				test[i * 84 + j * 3] = (byte) 120;
				test[(i * 84 + j * 3) + 72] = (byte) 120;
			}
		}

		return test;

	}

	private byte[] coloringTurquoise(Model world, byte[] test) {
		int x = world.getPlayerRX();
		int y = world.getPlayerRY();

		for (int i = 0; i < 10; i++) {
			test[14 + (y * 168) + (x * 15) + 3 * i] = (byte) 255;
			test[14 + (y * 168) + (x * 15) + (3 * i) - 84] = (byte) 255;
			test[13 + (y * 168) + (x * 15) + 3 * i] = (byte) 245;
			test[13 + (y * 168) + (x * 15) + (3 * i) - 84] = (byte) 245;

			test[14 + (y * 168) + ((x * 15) + 3 * i) - 168] = (byte) 255;
			test[14 + (y * 168) + (x * 15) + (3 * i) - 252] = (byte) 255;
			test[13 + (y * 168) + ((x * 15) + 3 * i) - 168] = (byte) 245;
			test[13 + (y * 168) + (x * 15) + (3 * i) - 252] = (byte) 245;

		}
		return test;
	}

	private byte[] coloringYellow(Model world, byte[] test) {
		int x = world.getPlayerULX();
		int y = world.getPlayerULY();

		for (int i = 0; i < 10; i++) {
			test[12 + (y * 168) + (x * 15) + 3 * i] = (byte) 255;
			test[12 + (y * 168) + (x * 15) + (3 * i) - 84] = (byte) 255;
			test[13 + (y * 168) + (x * 15) + 3 * i] = (byte) 255;
			test[13 + (y * 168) + (x * 15) + (3 * i) - 84] = (byte) 255;

		}
		for (int i = 0; i < 5; i++) {
			test[12 + (y * 168) + (x * 15) + (3 * i) - 168] = (byte) 255;
			test[12 + (y * 168) + (x * 15) + (3 * i) - 252] = (byte) 255;
			test[13 + (y * 168) + (x * 15) + (3 * i) - 168] = (byte) 255;
			test[13 + (y * 168) + (x * 15) + (3 * i) - 252] = (byte) 255;
		}

		return test;

	}

	private byte[] coloringGreen(Model world, byte[] test) {
		int x = world.getPlayerURX();
		int y = world.getPlayerURY();

		for (int i = 0; i < 10; i++) {
			test[13 + (y * 168) + (x * 15) + 3 * i] = (byte) 255;
			test[13 + (y * 168) + (x * 15) + (3 * i) - 84] = (byte) 255;

		}
		for (int i = 0; i < 5; i++) {
			test[13 + (y * 168) + ((x + 1) * 15) + (3 * i) - 168] = (byte) 255;
			test[13 + (y * 168) + ((x + 1) * 15) + (3 * i) - 252] = (byte) 255;
		}

		return test;

	}

	private byte[] coloringBlue(Model world, byte[] test) {
		int x = world.getPlayerORX();
		int y = world.getPlayerORY();

		for (int i = 0; i < 10; i++) {
			test[14 + (y * 168) + (x * 15) + 3 * i] = (byte) 255;
			test[14 + (y * 168) + (x * 15) + (3 * i) - 84] = (byte) 255;

		}
		for (int i = 0; i < 5; i++) {
			test[14 + (y * 168) + ((x + 1) * 15) + (3 * i) + 84] = (byte) 255;
			test[14 + (y * 168) + ((x + 1) * 15) + (3 * i) + 168] = (byte) 255;
		}
		return test;

	}

	private byte[] coloringRed(Model world, byte[] test) {
		int x = world.getPlayerOLX();
		int y = world.getPlayerOLY();

		for (int i = 0; i < 5; i++) {
			test[12 + (y * 168) + ((x * 15) + 3 * i)] = (byte) 255;
			test[12 + (y * 168) + ((x * 15) + (3 * i)) - 84] = (byte) 255;

		}
		for (int i = 0; i < 10; i++) {
			test[12 + (y * 168) + (x * 15) + (3 * i) - 168] = (byte) 255;
			test[12 + (y * 168) + (x * 15) + (3 * i) - 252] = (byte) 255;
		}
		return test;

	}

	

}

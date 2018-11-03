

import java.util.Observable;
import java.util.Observer;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class Control extends Observable {

	private GpioController gpio;
	private GpioPinDigitalInput cima;
	private GpioPinDigitalInput esquerda;
	private GpioPinDigitalInput baixo;
	private GpioPinDigitalInput direita;
	private GpioPinDigitalInput A;
	private GpioPinDigitalInput B;
	private GpioPinDigitalOutput LED;

	private boolean btnCima;
	private boolean btnBaixo;
	private boolean btnEsquerda;
	private boolean btnDireita;
	private boolean btnA;
	private boolean btnB;

	public Control() {

		setBtnCima(false);
		setBtnBaixo(false);
		setBtnEsquerda(false);
		setBtnDireita(false);
		setBtnA(false);
		setBtnB(false);

		gpio = GpioFactory.getInstance();

		cima = gpio.provisionDigitalInputPin(RaspiPin.GPIO_07, // PIN NUMBER
				"Cima", // PIN FRIENDLY NAME (optional)
				PinPullResistance.PULL_UP); // PIN RESISTANCE (optional)

		esquerda = gpio.provisionDigitalInputPin(RaspiPin.GPIO_02, // PIN NUMBER
				"Esquerda", // PIN FRIENDLY NAME (optional)
				PinPullResistance.PULL_UP); // PIN RESISTANCE (optional)

		baixo = gpio.provisionDigitalInputPin(RaspiPin.GPIO_00, // PIN NUMBER
				"Baixo", // PIN FRIENDLY NAME (optional)
				PinPullResistance.PULL_UP); // PIN RESISTANCE (optional)

		direita = gpio.provisionDigitalInputPin(RaspiPin.GPIO_03, // PIN NUMBER
				"Direita", // PIN FRIENDLY NAME (optional)
				PinPullResistance.PULL_UP); // PIN RESISTANCE (optional)

		A = gpio.provisionDigitalInputPin(RaspiPin.GPIO_06, // PIN NUMBER
				"A", // PIN FRIENDLY NAME (optional)
				PinPullResistance.PULL_UP); // PIN RESISTANCE (optional)

		B = gpio.provisionDigitalInputPin(RaspiPin.GPIO_05, // PIN NUMBER
				"B", // PIN FRIENDLY NAME (optional)
				PinPullResistance.PULL_UP); // PIN RESISTANCE (optional)

		LED = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08, "MyLED",
				PinState.HIGH);

		Thread t = new Thread(new Runnable() {

			public void run() {
				while (true) {

					if (!cima.isHigh()) {
						
						setBtnCima(true);
					} else {
						setBtnCima(false);
					}

					if (!esquerda.isHigh()) {
						
						setBtnEsquerda(true);
					} else {
						setBtnEsquerda(false);
					}
					if (!baixo.isHigh()) {
						
						setBtnBaixo(true);
					} else {
						setBtnBaixo(false);
					}
					if (!direita.isHigh()) {
						
						setBtnDireita(true);
					} else {
						setBtnDireita(false);
					}

					if (!A.isHigh()) {
						
						setBtnA(true);
					} else {
						setBtnA(false);
					}

					if (!B.isHigh()) {
						setBtnB(true);
					} else {
						setBtnB(false);
					}

					
					setChanged();
					notifyObservers();
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}
		});
		t.start();
	}

	public void addListener(Observer obs) {
		addObserver(obs);

	}

	public void stateLed(boolean state) {
		LED.setState(state);
	}

	public boolean isBtnCima() {
		return btnCima;
	}

	public void setBtnCima(boolean btnCima) {
		this.btnCima = btnCima;
	}

	public boolean isBtnBaixo() {
		return btnBaixo;
	}

	public void setBtnBaixo(boolean btnBaixo) {
		this.btnBaixo = btnBaixo;
	}

	public boolean isBtnEsquerda() {
		return btnEsquerda;
	}

	public void setBtnEsquerda(boolean btnEsquerda) {
		this.btnEsquerda = btnEsquerda;
	}

	public boolean isBtnDireita() {
		return btnDireita;
	}

	public void setBtnDireita(boolean btnDireita) {
		this.btnDireita = btnDireita;
	}

	public boolean isBtnA() {
		return btnA;
	}

	public void setBtnA(boolean btnA) {
		this.btnA = btnA;
	}

	public boolean isBtnB() {
		return btnB;
	}

	public void setBtnB(boolean btnB) {
		this.btnB = btnB;
	}

}

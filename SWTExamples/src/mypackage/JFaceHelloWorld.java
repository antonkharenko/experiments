package mypackage;

import java.sql.Timestamp;
import java.util.Locale;

import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;

import com.ibm.icu.text.DateFormat;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.TimeZone;

public class JFaceHelloWorld extends ApplicationWindow {
	
	private DateTime date;
	private DateTime time;
	
	public JFaceHelloWorld() {
		super(null);
	}

	public void run() {
		setBlockOnOpen(true);
		open();
		Display.getCurrent().dispose();
	}

	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, 0);
		date = new DateTime(composite, SWT.DATE | SWT.MEDIUM | SWT.DROP_DOWN); 
		time = new DateTime(composite, SWT.TIME | SWT.SHORT);
		Button printButton = new Button(composite, 0);
		printButton.setText("Print");
		printButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				printSelectedDate();
			}
		});
		composite.setLayout(new GridLayout(2, false));
		return composite;
	}
	
	private void printSelectedDate() {
		Timestamp dateMediator = getSelectedDate();
		Calendar outCalendar = Calendar.getInstance(TimeZone.getTimeZone("Etc/Greenwich"));
		DateFormat df = outCalendar.getDateTimeFormat(DateFormat.MEDIUM, DateFormat.SHORT, Locale.getDefault());
		System.out.println("Selected date is " + df.format(dateMediator) + ", isn't it?");
	}
	
	private Timestamp getSelectedDate() {
		Calendar inCalendar = Calendar.getInstance(TimeZone.getTimeZone("Etc/Greenwich"));
		inCalendar.set(date.getYear(), date.getMonth(), date.getDay(), time.getHours(), time.getMinutes(), 0);
		return new Timestamp(inCalendar.getTimeInMillis());
	}
	
	public static void main(String[] args) {
		new JFaceHelloWorld().run();
	}
}
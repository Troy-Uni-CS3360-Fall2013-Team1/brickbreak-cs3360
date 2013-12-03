package edu.troy.cs3360.fall2013.team1.brickbreak.engine;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Xml;

public class LevelBrickReadParser {
	
	
	//-----Data Constants
	private static final String ns = null;
	
	//-----Constructors
	public LevelBrickReadParser(){
		
	}
	
	/**
	 * This class takes an input stream and parses it into an ArrayList of Bricks.
	 * @author Dexter Parks
	 * @version 1.0
	 * @param The input stream of the XML brick level.
	 * @return Returns an ArrayList of bricks.
	 * @throws XmlPullParserException
	 * @throws IOException
	 */
	public List<Brick> parse(InputStream in) throws XmlPullParserException, IOException {
		
		try {
			XmlPullParser parser = Xml.newPullParser();
			parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
			parser.setInput(in, null);
			return readLevelBrick(parser);
		}
			finally {
			in.close();
		}
	}

	private List<Brick> readLevelBrick(XmlPullParser parser) throws XmlPullParserException, IOException {
		List<Brick> bricks = new ArrayList<Brick>();
		
		parser.require(XmlPullParser.START_TAG, ns, "bricklevel");
		while (parser.next() != XmlPullParser.END_TAG) {
			if(parser.getEventType() != XmlPullParser.START_TAG) {
				continue;
			}
			
			String name = parser.getName();
			
			if (name.equals("brick")) {
				bricks.add(readBrick(parser));
			} else {
				skip(parser);
			}
			
			
		}
		return null;
	}

	private void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
		if(parser.getEventType() !=  XmlPullParser.START_TAG) {
			throw new IllegalStateException();
		}
		int depth = 1;
		while (depth != 0) {
			switch (parser.next()) {
			case XmlPullParser.END_TAG:
				depth--;
				break;
			case XmlPullParser.START_TAG:
				depth++;
				break;
			}
		}
		
	}

	private Brick readBrick(XmlPullParser parser) throws XmlPullParserException, IOException {
		parser.require(XmlPullParser.START_TAG, ns, "brick");
		
		float mXPosition = 0;
		float mYPosition = 0;
		float mWidth = 0;
		float mHeight = 0;
		int mBrickValue = 0; 
		Colors mColor = Colors.Grey;
		
		while(parser.next() != XmlPullParser.END_TAG) {
			if(parser.getEventType() != XmlPullParser.START_TAG) {
				continue;
			}
			String name = parser.getName();
			if (name.equals("xposition")) {
				mXPosition = readXPosition(parser);
			} else if(name.equals("yposition")) {
				mYPosition = readYPosition(parser);
			} else if(name.equals("width")) {
				mWidth = readWidth(parser);
			} else if(name.equals("height")) {
				mHeight = readHeight(parser);
			} else if(name.equals("brickvalue")) {
				mBrickValue = readBrickValue(parser);
			} else if (name.equals("color")) {
				mColor = readColor(parser);
			}
		}
		return new Brick(mXPosition, mYPosition, mWidth, mHeight).setBrickValue(mBrickValue).setColor(mColor);
	}

	
	private String readText(XmlPullParser parser) throws XmlPullParserException, IOException {
		String result = "";
		if(parser.next() == XmlPullParser.TEXT) {
			result = parser.getText();
			parser.nextTag();
		}
		return result;
	}
	
	
	private float readFloat(XmlPullParser parser) throws XmlPullParserException, IOException {
		float result = 0;
		if(parser.next() == XmlPullParser.TEXT) {
			result = Float.parseFloat(parser.getText());
			parser.nextTag();
		}
		return result;
	}
	
	
	private int readInt(XmlPullParser parser) throws NumberFormatException, XmlPullParserException, IOException {
		int result = 0;
		if(parser.next() == XmlPullParser.TEXT) {
			result = Integer.parseInt(parser.getText());
			parser.nextTag();
		}
		return result;
	}

	private Colors readColor(XmlPullParser parser) throws XmlPullParserException, IOException {
		parser.require(XmlPullParser.START_TAG, ns, "color");
		String color = readText(parser);
		Colors mColorType;
		parser.require(XmlPullParser.END_TAG, ns, "color");
		
		if (color.equals("Blue")) {
			mColorType = Colors.Blue;
		} else if(color.equals("Cyan")) {
			mColorType = Colors.Cyan;
		}  else if(color.equals("Light_Blue")) {
			mColorType = Colors.Light_Blue;
		} else if(color.equals("Lime")) {
			mColorType = Colors.Lime;
		} else if(color.equals("Magenta")) {
			mColorType = Colors.Magenta;
		} else if(color.equals("Orange")) {
			mColorType = Colors.Orange;
		} else if(color.equals("Purple")) {
			mColorType = Colors.Purple;
		} else if(color.equals("Red")) {
			mColorType = Colors.Red;
		} else if(color.equals("Yellow")) {
			mColorType = Colors.Yellow;
		} else {
			mColorType = Colors.Grey;
		}
		return mColorType;
	}

	private int readBrickValue(XmlPullParser parser) throws XmlPullParserException, IOException {
		parser.require(XmlPullParser.START_TAG, ns, "brickvalue");
		int number = readInt(parser);
		parser.require(XmlPullParser.END_TAG, ns, "brickvalue");
		return number;
	}

	

	private float readHeight(XmlPullParser parser) throws XmlPullParserException, IOException {
		parser.require(XmlPullParser.START_TAG, ns, "height");
		float number = readFloat(parser);
		parser.require(XmlPullParser.END_TAG, ns, "height");
		return number;
	}

	private float readWidth(XmlPullParser parser) throws XmlPullParserException, IOException {
		parser.require(XmlPullParser.START_TAG, ns, "width");
		float number = readFloat(parser);
		parser.require(XmlPullParser.END_TAG, ns, "width");
		return number;
	}

	private float readYPosition(XmlPullParser parser) throws XmlPullParserException, IOException {
		parser.require(XmlPullParser.START_TAG, ns, "yposition");
		float number = readFloat(parser);
		parser.require(XmlPullParser.END_TAG, ns, "yposition");
		return number;
	}

	private float readXPosition(XmlPullParser parser) throws XmlPullParserException, IOException {
		parser.require(XmlPullParser.START_TAG, ns, "xposition");
		float number = readFloat(parser);
		parser.require(XmlPullParser.END_TAG, ns, "xposition");
		return number;
	}
}

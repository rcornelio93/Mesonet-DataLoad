package com.mesonet.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STATIONDETAILS") 
public class StationWeatherDetails {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer id;
		private String stationId;
		private String providerId;
		private String handbook5Id;
		private String stationName;
		private String homeWFO;
		private int numericWMOid;
		private String stationType;
		private String dataProvider;
		private float latitude;
		private float longitude;
		private float elevation;
		private double observationTime;
		private double reportTime;
		private double receivedTime;
		private float temperature;
		private double tempChangeTime;
		private char temperatureDD;
		private int temperatureQCA;
		private int temperatureQCR;
		private float temperatureQCD;
		private int temperatureICA;
		private int temperatureICR;
		private float dewpoint;
		private char dewpointDD;
		private int dewpointQCA;
		private int dewpointQCR;
		private float dewpointQCD;
		private int dewpointICA;
		private int dewpointICR;
		private float relHumidity;
		private double rhChangetime;
		private char relHumidityDD;
		private int relHumidityQCA;
		private int relHumidityQCR;
		private float relHumidityQCD;
		private float stationPressure;
		private double stationPressChangeTime;
		private char stationPressureDD;
		private int stationPressureQCA;
		private int stationPressureQCR;
		private float stationPressureQCD;
		private int stationPressureICA;
		private int stationPressureICR;
		private float seaLevelPressure;
		private char seaLevelPressureDD;
		private int seaLevelPressureQCA;
		private int seaLevelPressureQCR;
		private float seaLevelPressureQCD;
		private int seaLevelPressureICA;
		private int seaLevelPressureICR;
		private short pressChangeChar;
		private float pressChange3Hour;
		private char pressChange3HourDD;
		private int pressChange3HourQCA;
		private int pressChange3HourQCR;
		private float pressChange3HourQCD;
		private int pressChange3HourICA;
		private int pressChange3HourICR;
		private float altimeter;
		private char altimeterDD;
		private int altimeterQCA;
		private int altimeterQCR;
		private float altimeterQCD;
		private float windDir;
		private double windDirChangeTime;
		private char windDirDD;
		private int windDirQCA;
		private int windDirQCR;
		private float windDirQCD;
		private int windDirICA;
		private int windDirICR;
		private float windSpeed;
		private double windSpeedChangeTime;
		private char windSpeedDD;
		private int windSpeedQCA;
		private int windSpeedQCR;
		private float windSpeedQCD;
		private int windSpeedICA;
		private int windSpeedICR;
		private float windGust;
		private double windGustChangeTime;
		private char windGustDD;
		private int windGustQCA;
		private int windGustQCR;
		private float windGustQCD;
		private float windDirMax;
		private char windDirMaxDD;
		private int windDirMaxQCA;
		private int windDirMaxQCR;
		private float windDirMaxQCD;
		private float visibility;
		private char visibilityDD;
		private int visibilityQCA;
		private int visibilityQCR;
		private float visibilityQCD;
		private int visibilityICA;
		private int visibilityICR;
		private float rawPrecip;
		private float precipAccum;
		private char precipAccumDD;
		private int precipAccumQCA;
		private int precipAccumQCR;
		private float precipAccumQCD;
		private int precipAccumICA;
		private int precipAccumICR;
		private float precipRate;
		private char precipRateDD;
		private int precipRateQCA;
		private int precipRateQCR;
		private float precipRateQCD;
		private short precipType;
		private short precipIntensity;
		private double timeSinceLastPcp;
		private float solarRadiation;
		private double solarRadChangeTime;
		private float seaSurfaceTemp;
		private char seaSurfaceTempDD;
		private int seaSurfaceTempQCA;
		private int seaSurfaceTempQCR;
		private float seaSurfaceTempQCD;
		private float seaSurfaceTempICA;
		private float seaSurfaceTempICR;
		private String rawMessage;
		private float totalColumnPMV;
		private float totalSignalDelay;
		private float drySignalDelay;
		private float wetSignalDelay;
		private float meanWeightedTemperature;
		private float formalError;
		private float capPi;
		private float roadTemperature1;
		private float roadTemperature2;
		private float roadTemperature3;
		private float roadTemperature4;
		private float roadLiquidFreezeTemp1;
		private float roadLiquidFreezeTemp2;
		private float roadLiquidFreezeTemp3;
		private float roadLiquidFreezeTemp4;
		private float roadLiquidChemFactor1;
		private float roadLiquidChemFactor2;
		private float roadLiquidChemFactor3;
		private float roadLiquidChemFactor4;
		private float roadLiquidChemPercent1;
		private float roadLiquidChemPercent2;
		private float roadLiquidChemPercent3;
		private float roadLiquidChemPercent4;
		private float roadLiquidIcePercent1;
		private float roadLiquidIcePercent2;
		private float roadLiquidIcePercent3;
		private float roadLiquidIcePercent4;
		private float roadLiquidDepth1;
		private float roadLiquidDepth2;
		private float roadLiquidDepth3;
		private float roadLiquidDepth4;
		private short roadState1;
		private short roadState2;
		private short roadState3;
		private short roadState4;
		private float roadSubSurfaceTemp1;
		private float roadSubSurfaceTemp2;
		private float roadSubSurfaceTemp3;
		private float roadSubSurfaceTemp4;
		private float fuelTemperature;
		private double fuelTempChangeTime;
		private float fuelMoisture;
		private double fuelMoistChangeTime;
		private float soilTemperature;
		private char soilTemperatureDD;
		private int soilTemperatureQCA;
		private int soilTemperatureQCR;
		private float soilTemperatureQCD;
		private float soilMoisture;
		private float soilMoisturePercent;
		private char soilMoisturePercentDD;
		private int soilMoisturePercentQCA;
		private int soilMoisturePercentQCR;
		private float soilMoisturePercentQCD;
		private float waterLevel;
		private float mobileLat;
		private float mobileLon;
		private float mobileElev;
		public String getStationId() {
			return stationId;
		}
		public void setStationId(String stationId) {
			this.stationId = stationId;
		}
		public String getProviderId() {
			return providerId;
		}
		public void setProviderId(String providerId) {
			this.providerId = providerId;
		}
		public String getHandbook5Id() {
			return handbook5Id;
		}
		public void setHandbook5Id(String handbook5Id) {
			this.handbook5Id = handbook5Id;
		}
		public String getStationName() {
			return stationName;
		}
		public void setStationName(String stationName) {
			this.stationName = stationName;
		}
		public String getHomeWFO() {
			return homeWFO;
		}
		public void setHomeWFO(String homeWFO) {
			this.homeWFO = homeWFO;
		}
		public int getNumericWMOid() {
			return numericWMOid;
		}
		public void setNumericWMOid(int numericWMOid) {
			this.numericWMOid = numericWMOid;
		}
		public String getStationType() {
			return stationType;
		}
		public void setStationType(String stationType) {
			this.stationType = stationType;
		}
		public String getDataProvider() {
			return dataProvider;
		}
		public void setDataProvider(String dataProvider) {
			this.dataProvider = dataProvider;
		}
		public float getLatitude() {
			return latitude;
		}
		public void setLatitude(float latitude) {
			this.latitude = latitude;
		}
		public float getLongitude() {
			return longitude;
		}
		public void setLongitude(float longitude) {
			this.longitude = longitude;
		}
		public float getElevation() {
			return elevation;
		}
		public void setElevation(float elevation) {
			this.elevation = elevation;
		}
		public double getObservationTime() {
			return observationTime;
		}
		public void setObservationTime(double observationTime) {
			this.observationTime = observationTime;
		}
		public double getReportTime() {
			return reportTime;
		}
		public void setReportTime(double reportTime) {
			this.reportTime = reportTime;
		}
		public double getReceivedTime() {
			return receivedTime;
		}
		public void setReceivedTime(double receivedTime) {
			this.receivedTime = receivedTime;
		}
		public float getTemperature() {
			return temperature;
		}
		public void setTemperature(float temperature) {
			this.temperature = temperature;
		}
		public double getTempChangeTime() {
			return tempChangeTime;
		}
		public void setTempChangeTime(double tempChangeTime) {
			this.tempChangeTime = tempChangeTime;
		}
		public char getTemperatureDD() {
			return temperatureDD;
		}
		public void setTemperatureDD(char temperatureDD) {
			this.temperatureDD = temperatureDD;
		}
		public int getTemperatureQCA() {
			return temperatureQCA;
		}
		public void setTemperatureQCA(int temperatureQCA) {
			this.temperatureQCA = temperatureQCA;
		}
		public int getTemperatureQCR() {
			return temperatureQCR;
		}
		public void setTemperatureQCR(int temperatureQCR) {
			this.temperatureQCR = temperatureQCR;
		}
		public float getTemperatureQCD() {
			return temperatureQCD;
		}
		public void setTemperatureQCD(float temperatureQCD) {
			this.temperatureQCD = temperatureQCD;
		}
		public int getTemperatureICA() {
			return temperatureICA;
		}
		public void setTemperatureICA(int temperatureICA) {
			this.temperatureICA = temperatureICA;
		}
		public int getTemperatureICR() {
			return temperatureICR;
		}
		public void setTemperatureICR(int temperatureICR) {
			this.temperatureICR = temperatureICR;
		}
		public float getDewpoint() {
			return dewpoint;
		}
		public void setDewpoint(float dewpoint) {
			this.dewpoint = dewpoint;
		}
		public char getDewpointDD() {
			return dewpointDD;
		}
		public void setDewpointDD(char dewpointDD) {
			this.dewpointDD = dewpointDD;
		}
		public int getDewpointQCA() {
			return dewpointQCA;
		}
		public void setDewpointQCA(int dewpointQCA) {
			this.dewpointQCA = dewpointQCA;
		}
		public int getDewpointQCR() {
			return dewpointQCR;
		}
		public void setDewpointQCR(int dewpointQCR) {
			this.dewpointQCR = dewpointQCR;
		}
		public float getDewpointQCD() {
			return dewpointQCD;
		}
		public void setDewpointQCD(float dewpointQCD) {
			this.dewpointQCD = dewpointQCD;
		}
		public int getDewpointICA() {
			return dewpointICA;
		}
		public void setDewpointICA(int dewpointICA) {
			this.dewpointICA = dewpointICA;
		}
		public int getDewpointICR() {
			return dewpointICR;
		}
		public void setDewpointICR(int dewpointICR) {
			this.dewpointICR = dewpointICR;
		}
		public float getRelHumidity() {
			return relHumidity;
		}
		public void setRelHumidity(float relHumidity) {
			this.relHumidity = relHumidity;
		}
		public double getRhChangetime() {
			return rhChangetime;
		}
		public void setRhChangetime(double rhChangetime) {
			this.rhChangetime = rhChangetime;
		}
		public char getRelHumidityDD() {
			return relHumidityDD;
		}
		public void setRelHumidityDD(char relHumidityDD) {
			this.relHumidityDD = relHumidityDD;
		}
		public int getRelHumidityQCA() {
			return relHumidityQCA;
		}
		public void setRelHumidityQCA(int relHumidityQCA) {
			this.relHumidityQCA = relHumidityQCA;
		}
		public int getRelHumidityQCR() {
			return relHumidityQCR;
		}
		public void setRelHumidityQCR(int relHumidityQCR) {
			this.relHumidityQCR = relHumidityQCR;
		}
		public float getRelHumidityQCD() {
			return relHumidityQCD;
		}
		public void setRelHumidityQCD(float relHumidityQCD) {
			this.relHumidityQCD = relHumidityQCD;
		}
		public float getStationPressure() {
			return stationPressure;
		}
		public void setStationPressure(float stationPressure) {
			this.stationPressure = stationPressure;
		}
		public double getStationPressChangeTime() {
			return stationPressChangeTime;
		}
		public void setStationPressChangeTime(double stationPressChangeTime) {
			this.stationPressChangeTime = stationPressChangeTime;
		}
		public char getStationPressureDD() {
			return stationPressureDD;
		}
		public void setStationPressureDD(char stationPressureDD) {
			this.stationPressureDD = stationPressureDD;
		}
		public int getStationPressureQCA() {
			return stationPressureQCA;
		}
		public void setStationPressureQCA(int stationPressureQCA) {
			this.stationPressureQCA = stationPressureQCA;
		}
		public int getStationPressureQCR() {
			return stationPressureQCR;
		}
		public void setStationPressureQCR(int stationPressureQCR) {
			this.stationPressureQCR = stationPressureQCR;
		}
		public float getStationPressureQCD() {
			return stationPressureQCD;
		}
		public void setStationPressureQCD(float stationPressureQCD) {
			this.stationPressureQCD = stationPressureQCD;
		}
		public int getStationPressureICA() {
			return stationPressureICA;
		}
		public void setStationPressureICA(int stationPressureICA) {
			this.stationPressureICA = stationPressureICA;
		}
		public int getStationPressureICR() {
			return stationPressureICR;
		}
		public void setStationPressureICR(int stationPressureICR) {
			this.stationPressureICR = stationPressureICR;
		}
		public float getSeaLevelPressure() {
			return seaLevelPressure;
		}
		public void setSeaLevelPressure(float seaLevelPressure) {
			this.seaLevelPressure = seaLevelPressure;
		}
		public char getSeaLevelPressureDD() {
			return seaLevelPressureDD;
		}
		public void setSeaLevelPressureDD(char seaLevelPressureDD) {
			this.seaLevelPressureDD = seaLevelPressureDD;
		}
		public int getSeaLevelPressureQCA() {
			return seaLevelPressureQCA;
		}
		public void setSeaLevelPressureQCA(int seaLevelPressureQCA) {
			this.seaLevelPressureQCA = seaLevelPressureQCA;
		}
		public int getSeaLevelPressureQCR() {
			return seaLevelPressureQCR;
		}
		public void setSeaLevelPressureQCR(int seaLevelPressureQCR) {
			this.seaLevelPressureQCR = seaLevelPressureQCR;
		}
		public float getSeaLevelPressureQCD() {
			return seaLevelPressureQCD;
		}
		public void setSeaLevelPressureQCD(float seaLevelPressureQCD) {
			this.seaLevelPressureQCD = seaLevelPressureQCD;
		}
		public int getSeaLevelPressureICA() {
			return seaLevelPressureICA;
		}
		public void setSeaLevelPressureICA(int seaLevelPressureICA) {
			this.seaLevelPressureICA = seaLevelPressureICA;
		}
		public int getSeaLevelPressureICR() {
			return seaLevelPressureICR;
		}
		public void setSeaLevelPressureICR(int seaLevelPressureICR) {
			this.seaLevelPressureICR = seaLevelPressureICR;
		}
		public short getPressChangeChar() {
			return pressChangeChar;
		}
		public void setPressChangeChar(short pressChangeChar) {
			this.pressChangeChar = pressChangeChar;
		}
		public float getPressChange3Hour() {
			return pressChange3Hour;
		}
		public void setPressChange3Hour(float pressChange3Hour) {
			this.pressChange3Hour = pressChange3Hour;
		}
		public char getPressChange3HourDD() {
			return pressChange3HourDD;
		}
		public void setPressChange3HourDD(char pressChange3HourDD) {
			this.pressChange3HourDD = pressChange3HourDD;
		}
		public int getPressChange3HourQCA() {
			return pressChange3HourQCA;
		}
		public void setPressChange3HourQCA(int pressChange3HourQCA) {
			this.pressChange3HourQCA = pressChange3HourQCA;
		}
		public int getPressChange3HourQCR() {
			return pressChange3HourQCR;
		}
		public void setPressChange3HourQCR(int pressChange3HourQCR) {
			this.pressChange3HourQCR = pressChange3HourQCR;
		}
		public float getPressChange3HourQCD() {
			return pressChange3HourQCD;
		}
		public void setPressChange3HourQCD(float pressChange3HourQCD) {
			this.pressChange3HourQCD = pressChange3HourQCD;
		}
		public int getPressChange3HourICA() {
			return pressChange3HourICA;
		}
		public void setPressChange3HourICA(int pressChange3HourICA) {
			this.pressChange3HourICA = pressChange3HourICA;
		}
		public int getPressChange3HourICR() {
			return pressChange3HourICR;
		}
		public void setPressChange3HourICR(int pressChange3HourICR) {
			this.pressChange3HourICR = pressChange3HourICR;
		}
		public float getAltimeter() {
			return altimeter;
		}
		public void setAltimeter(float altimeter) {
			this.altimeter = altimeter;
		}
		public char getAltimeterDD() {
			return altimeterDD;
		}
		public void setAltimeterDD(char altimeterDD) {
			this.altimeterDD = altimeterDD;
		}
		public int getAltimeterQCA() {
			return altimeterQCA;
		}
		public void setAltimeterQCA(int altimeterQCA) {
			this.altimeterQCA = altimeterQCA;
		}
		public int getAltimeterQCR() {
			return altimeterQCR;
		}
		public void setAltimeterQCR(int altimeterQCR) {
			this.altimeterQCR = altimeterQCR;
		}
		public float getAltimeterQCD() {
			return altimeterQCD;
		}
		public void setAltimeterQCD(float altimeterQCD) {
			this.altimeterQCD = altimeterQCD;
		}
		public float getWindDir() {
			return windDir;
		}
		public void setWindDir(float windDir) {
			this.windDir = windDir;
		}
		public double getWindDirChangeTime() {
			return windDirChangeTime;
		}
		public void setWindDirChangeTime(double windDirChangeTime) {
			this.windDirChangeTime = windDirChangeTime;
		}
		public char getWindDirDD() {
			return windDirDD;
		}
		public void setWindDirDD(char windDirDD) {
			this.windDirDD = windDirDD;
		}
		public int getWindDirQCA() {
			return windDirQCA;
		}
		public void setWindDirQCA(int windDirQCA) {
			this.windDirQCA = windDirQCA;
		}
		public int getWindDirQCR() {
			return windDirQCR;
		}
		public void setWindDirQCR(int windDirQCR) {
			this.windDirQCR = windDirQCR;
		}
		public float getWindDirQCD() {
			return windDirQCD;
		}
		public void setWindDirQCD(float windDirQCD) {
			this.windDirQCD = windDirQCD;
		}
		public int getWindDirICA() {
			return windDirICA;
		}
		public void setWindDirICA(int windDirICA) {
			this.windDirICA = windDirICA;
		}
		public int getWindDirICR() {
			return windDirICR;
		}
		public void setWindDirICR(int windDirICR) {
			this.windDirICR = windDirICR;
		}
		public float getWindSpeed() {
			return windSpeed;
		}
		public void setWindSpeed(float windSpeed) {
			this.windSpeed = windSpeed;
		}
		public double getWindSpeedChangeTime() {
			return windSpeedChangeTime;
		}
		public void setWindSpeedChangeTime(double windSpeedChangeTime) {
			this.windSpeedChangeTime = windSpeedChangeTime;
		}
		public char getWindSpeedDD() {
			return windSpeedDD;
		}
		public void setWindSpeedDD(char windSpeedDD) {
			this.windSpeedDD = windSpeedDD;
		}
		public int getWindSpeedQCA() {
			return windSpeedQCA;
		}
		public void setWindSpeedQCA(int windSpeedQCA) {
			this.windSpeedQCA = windSpeedQCA;
		}
		public int getWindSpeedQCR() {
			return windSpeedQCR;
		}
		public void setWindSpeedQCR(int windSpeedQCR) {
			this.windSpeedQCR = windSpeedQCR;
		}
		public float getWindSpeedQCD() {
			return windSpeedQCD;
		}
		public void setWindSpeedQCD(float windSpeedQCD) {
			this.windSpeedQCD = windSpeedQCD;
		}
		public int getWindSpeedICA() {
			return windSpeedICA;
		}
		public void setWindSpeedICA(int windSpeedICA) {
			this.windSpeedICA = windSpeedICA;
		}
		public int getWindSpeedICR() {
			return windSpeedICR;
		}
		public void setWindSpeedICR(int windSpeedICR) {
			this.windSpeedICR = windSpeedICR;
		}
		public float getWindGust() {
			return windGust;
		}
		public void setWindGust(float windGust) {
			this.windGust = windGust;
		}
		public double getWindGustChangeTime() {
			return windGustChangeTime;
		}
		public void setWindGustChangeTime(double windGustChangeTime) {
			this.windGustChangeTime = windGustChangeTime;
		}
		public char getWindGustDD() {
			return windGustDD;
		}
		public void setWindGustDD(char windGustDD) {
			this.windGustDD = windGustDD;
		}
		public int getWindGustQCA() {
			return windGustQCA;
		}
		public void setWindGustQCA(int windGustQCA) {
			this.windGustQCA = windGustQCA;
		}
		public int getWindGustQCR() {
			return windGustQCR;
		}
		public void setWindGustQCR(int windGustQCR) {
			this.windGustQCR = windGustQCR;
		}
		public float getWindGustQCD() {
			return windGustQCD;
		}
		public void setWindGustQCD(float windGustQCD) {
			this.windGustQCD = windGustQCD;
		}
		public float getWindDirMax() {
			return windDirMax;
		}
		public void setWindDirMax(float windDirMax) {
			this.windDirMax = windDirMax;
		}
		public char getWindDirMaxDD() {
			return windDirMaxDD;
		}
		public void setWindDirMaxDD(char windDirMaxDD) {
			this.windDirMaxDD = windDirMaxDD;
		}
		public int getWindDirMaxQCA() {
			return windDirMaxQCA;
		}
		public void setWindDirMaxQCA(int windDirMaxQCA) {
			this.windDirMaxQCA = windDirMaxQCA;
		}
		public int getWindDirMaxQCR() {
			return windDirMaxQCR;
		}
		public void setWindDirMaxQCR(int windDirMaxQCR) {
			this.windDirMaxQCR = windDirMaxQCR;
		}
		public float getWindDirMaxQCD() {
			return windDirMaxQCD;
		}
		public void setWindDirMaxQCD(float windDirMaxQCD) {
			this.windDirMaxQCD = windDirMaxQCD;
		}
		public float getVisibility() {
			return visibility;
		}
		public void setVisibility(float visibility) {
			this.visibility = visibility;
		}
		public char getVisibilityDD() {
			return visibilityDD;
		}
		public void setVisibilityDD(char visibilityDD) {
			this.visibilityDD = visibilityDD;
		}
		public int getVisibilityQCA() {
			return visibilityQCA;
		}
		public void setVisibilityQCA(int visibilityQCA) {
			this.visibilityQCA = visibilityQCA;
		}
		public int getVisibilityQCR() {
			return visibilityQCR;
		}
		public void setVisibilityQCR(int visibilityQCR) {
			this.visibilityQCR = visibilityQCR;
		}
		public float getVisibilityQCD() {
			return visibilityQCD;
		}
		public void setVisibilityQCD(float visibilityQCD) {
			this.visibilityQCD = visibilityQCD;
		}
		public int getVisibilityICA() {
			return visibilityICA;
		}
		public void setVisibilityICA(int visibilityICA) {
			this.visibilityICA = visibilityICA;
		}
		public int getVisibilityICR() {
			return visibilityICR;
		}
		public void setVisibilityICR(int visibilityICR) {
			this.visibilityICR = visibilityICR;
		}
		public float getRawPrecip() {
			return rawPrecip;
		}
		public void setRawPrecip(float rawPrecip) {
			this.rawPrecip = rawPrecip;
		}
		public float getPrecipAccum() {
			return precipAccum;
		}
		public void setPrecipAccum(float precipAccum) {
			this.precipAccum = precipAccum;
		}
		public char getPrecipAccumDD() {
			return precipAccumDD;
		}
		public void setPrecipAccumDD(char precipAccumDD) {
			this.precipAccumDD = precipAccumDD;
		}
		public int getPrecipAccumQCA() {
			return precipAccumQCA;
		}
		public void setPrecipAccumQCA(int precipAccumQCA) {
			this.precipAccumQCA = precipAccumQCA;
		}
		public int getPrecipAccumQCR() {
			return precipAccumQCR;
		}
		public void setPrecipAccumQCR(int precipAccumQCR) {
			this.precipAccumQCR = precipAccumQCR;
		}
		public float getPrecipAccumQCD() {
			return precipAccumQCD;
		}
		public void setPrecipAccumQCD(float precipAccumQCD) {
			this.precipAccumQCD = precipAccumQCD;
		}
		public int getPrecipAccumICA() {
			return precipAccumICA;
		}
		public void setPrecipAccumICA(int precipAccumICA) {
			this.precipAccumICA = precipAccumICA;
		}
		public int getPrecipAccumICR() {
			return precipAccumICR;
		}
		public void setPrecipAccumICR(int precipAccumICR) {
			this.precipAccumICR = precipAccumICR;
		}
		public float getPrecipRate() {
			return precipRate;
		}
		public void setPrecipRate(float precipRate) {
			this.precipRate = precipRate;
		}
		public char getPrecipRateDD() {
			return precipRateDD;
		}
		public void setPrecipRateDD(char precipRateDD) {
			this.precipRateDD = precipRateDD;
		}
		public int getPrecipRateQCA() {
			return precipRateQCA;
		}
		public void setPrecipRateQCA(int precipRateQCA) {
			this.precipRateQCA = precipRateQCA;
		}
		public int getPrecipRateQCR() {
			return precipRateQCR;
		}
		public void setPrecipRateQCR(int precipRateQCR) {
			this.precipRateQCR = precipRateQCR;
		}
		public float getPrecipRateQCD() {
			return precipRateQCD;
		}
		public void setPrecipRateQCD(float precipRateQCD) {
			this.precipRateQCD = precipRateQCD;
		}
		public short getPrecipType() {
			return precipType;
		}
		public void setPrecipType(short precipType) {
			this.precipType = precipType;
		}
		public short getPrecipIntensity() {
			return precipIntensity;
		}
		public void setPrecipIntensity(short precipIntensity) {
			this.precipIntensity = precipIntensity;
		}
		public double getTimeSinceLastPcp() {
			return timeSinceLastPcp;
		}
		public void setTimeSinceLastPcp(double timeSinceLastPcp) {
			this.timeSinceLastPcp = timeSinceLastPcp;
		}
		public float getSolarRadiation() {
			return solarRadiation;
		}
		public void setSolarRadiation(float solarRadiation) {
			this.solarRadiation = solarRadiation;
		}
		public double getSolarRadChangeTime() {
			return solarRadChangeTime;
		}
		public void setSolarRadChangeTime(double solarRadChangeTime) {
			this.solarRadChangeTime = solarRadChangeTime;
		}
		public float getSeaSurfaceTemp() {
			return seaSurfaceTemp;
		}
		public void setSeaSurfaceTemp(float seaSurfaceTemp) {
			this.seaSurfaceTemp = seaSurfaceTemp;
		}
		public char getSeaSurfaceTempDD() {
			return seaSurfaceTempDD;
		}
		public void setSeaSurfaceTempDD(char seaSurfaceTempDD) {
			this.seaSurfaceTempDD = seaSurfaceTempDD;
		}
		public int getSeaSurfaceTempQCA() {
			return seaSurfaceTempQCA;
		}
		public void setSeaSurfaceTempQCA(int seaSurfaceTempQCA) {
			this.seaSurfaceTempQCA = seaSurfaceTempQCA;
		}
		public int getSeaSurfaceTempQCR() {
			return seaSurfaceTempQCR;
		}
		public void setSeaSurfaceTempQCR(int seaSurfaceTempQCR) {
			this.seaSurfaceTempQCR = seaSurfaceTempQCR;
		}
		public float getSeaSurfaceTempQCD() {
			return seaSurfaceTempQCD;
		}
		public void setSeaSurfaceTempQCD(float seaSurfaceTempQCD) {
			this.seaSurfaceTempQCD = seaSurfaceTempQCD;
		}
		public float getSeaSurfaceTempICA() {
			return seaSurfaceTempICA;
		}
		public void setSeaSurfaceTempICA(float seaSurfaceTempICA) {
			this.seaSurfaceTempICA = seaSurfaceTempICA;
		}
		public float getSeaSurfaceTempICR() {
			return seaSurfaceTempICR;
		}
		public void setSeaSurfaceTempICR(float seaSurfaceTempICR) {
			this.seaSurfaceTempICR = seaSurfaceTempICR;
		}
		public String getRawMessage() {
			return rawMessage;
		}
		public void setRawMessage(String rawMessage) {
			this.rawMessage = rawMessage;
		}
		public float getTotalColumnPMV() {
			return totalColumnPMV;
		}
		public void setTotalColumnPMV(float totalColumnPMV) {
			this.totalColumnPMV = totalColumnPMV;
		}
		public float getTotalSignalDelay() {
			return totalSignalDelay;
		}
		public void setTotalSignalDelay(float totalSignalDelay) {
			this.totalSignalDelay = totalSignalDelay;
		}
		public float getDrySignalDelay() {
			return drySignalDelay;
		}
		public void setDrySignalDelay(float drySignalDelay) {
			this.drySignalDelay = drySignalDelay;
		}
		public float getWetSignalDelay() {
			return wetSignalDelay;
		}
		public void setWetSignalDelay(float wetSignalDelay) {
			this.wetSignalDelay = wetSignalDelay;
		}
		public float getMeanWeightedTemperature() {
			return meanWeightedTemperature;
		}
		public void setMeanWeightedTemperature(float meanWeightedTemperature) {
			this.meanWeightedTemperature = meanWeightedTemperature;
		}
		public float getFormalError() {
			return formalError;
		}
		public void setFormalError(float formalError) {
			this.formalError = formalError;
		}
		public float getCapPi() {
			return capPi;
		}
		public void setCapPi(float capPi) {
			this.capPi = capPi;
		}
		public float getRoadTemperature1() {
			return roadTemperature1;
		}
		public void setRoadTemperature1(float roadTemperature1) {
			this.roadTemperature1 = roadTemperature1;
		}
		public float getRoadTemperature2() {
			return roadTemperature2;
		}
		public void setRoadTemperature2(float roadTemperature2) {
			this.roadTemperature2 = roadTemperature2;
		}
		public float getRoadTemperature3() {
			return roadTemperature3;
		}
		public void setRoadTemperature3(float roadTemperature3) {
			this.roadTemperature3 = roadTemperature3;
		}
		public float getRoadTemperature4() {
			return roadTemperature4;
		}
		public void setRoadTemperature4(float roadTemperature4) {
			this.roadTemperature4 = roadTemperature4;
		}
		public float getRoadLiquidFreezeTemp1() {
			return roadLiquidFreezeTemp1;
		}
		public void setRoadLiquidFreezeTemp1(float roadLiquidFreezeTemp1) {
			this.roadLiquidFreezeTemp1 = roadLiquidFreezeTemp1;
		}
		public float getRoadLiquidFreezeTemp2() {
			return roadLiquidFreezeTemp2;
		}
		public void setRoadLiquidFreezeTemp2(float roadLiquidFreezeTemp2) {
			this.roadLiquidFreezeTemp2 = roadLiquidFreezeTemp2;
		}
		public float getRoadLiquidFreezeTemp3() {
			return roadLiquidFreezeTemp3;
		}
		public void setRoadLiquidFreezeTemp3(float roadLiquidFreezeTemp3) {
			this.roadLiquidFreezeTemp3 = roadLiquidFreezeTemp3;
		}
		public float getRoadLiquidFreezeTemp4() {
			return roadLiquidFreezeTemp4;
		}
		public void setRoadLiquidFreezeTemp4(float roadLiquidFreezeTemp4) {
			this.roadLiquidFreezeTemp4 = roadLiquidFreezeTemp4;
		}
		public float getRoadLiquidChemFactor1() {
			return roadLiquidChemFactor1;
		}
		public void setRoadLiquidChemFactor1(float roadLiquidChemFactor1) {
			this.roadLiquidChemFactor1 = roadLiquidChemFactor1;
		}
		public float getRoadLiquidChemFactor2() {
			return roadLiquidChemFactor2;
		}
		public void setRoadLiquidChemFactor2(float roadLiquidChemFactor2) {
			this.roadLiquidChemFactor2 = roadLiquidChemFactor2;
		}
		public float getRoadLiquidChemFactor3() {
			return roadLiquidChemFactor3;
		}
		public void setRoadLiquidChemFactor3(float roadLiquidChemFactor3) {
			this.roadLiquidChemFactor3 = roadLiquidChemFactor3;
		}
		public float getRoadLiquidChemFactor4() {
			return roadLiquidChemFactor4;
		}
		public void setRoadLiquidChemFactor4(float roadLiquidChemFactor4) {
			this.roadLiquidChemFactor4 = roadLiquidChemFactor4;
		}
		public float getRoadLiquidChemPercent1() {
			return roadLiquidChemPercent1;
		}
		public void setRoadLiquidChemPercent1(float roadLiquidChemPercent1) {
			this.roadLiquidChemPercent1 = roadLiquidChemPercent1;
		}
		public float getRoadLiquidChemPercent2() {
			return roadLiquidChemPercent2;
		}
		public void setRoadLiquidChemPercent2(float roadLiquidChemPercent2) {
			this.roadLiquidChemPercent2 = roadLiquidChemPercent2;
		}
		public float getRoadLiquidChemPercent3() {
			return roadLiquidChemPercent3;
		}
		public void setRoadLiquidChemPercent3(float roadLiquidChemPercent3) {
			this.roadLiquidChemPercent3 = roadLiquidChemPercent3;
		}
		public float getRoadLiquidChemPercent4() {
			return roadLiquidChemPercent4;
		}
		public void setRoadLiquidChemPercent4(float roadLiquidChemPercent4) {
			this.roadLiquidChemPercent4 = roadLiquidChemPercent4;
		}
		public float getRoadLiquidIcePercent1() {
			return roadLiquidIcePercent1;
		}
		public void setRoadLiquidIcePercent1(float roadLiquidIcePercent1) {
			this.roadLiquidIcePercent1 = roadLiquidIcePercent1;
		}
		public float getRoadLiquidIcePercent2() {
			return roadLiquidIcePercent2;
		}
		public void setRoadLiquidIcePercent2(float roadLiquidIcePercent2) {
			this.roadLiquidIcePercent2 = roadLiquidIcePercent2;
		}
		public float getRoadLiquidIcePercent3() {
			return roadLiquidIcePercent3;
		}
		public void setRoadLiquidIcePercent3(float roadLiquidIcePercent3) {
			this.roadLiquidIcePercent3 = roadLiquidIcePercent3;
		}
		public float getRoadLiquidIcePercent4() {
			return roadLiquidIcePercent4;
		}
		public void setRoadLiquidIcePercent4(float roadLiquidIcePercent4) {
			this.roadLiquidIcePercent4 = roadLiquidIcePercent4;
		}
		public float getRoadLiquidDepth1() {
			return roadLiquidDepth1;
		}
		public void setRoadLiquidDepth1(float roadLiquidDepth1) {
			this.roadLiquidDepth1 = roadLiquidDepth1;
		}
		public float getRoadLiquidDepth2() {
			return roadLiquidDepth2;
		}
		public void setRoadLiquidDepth2(float roadLiquidDepth2) {
			this.roadLiquidDepth2 = roadLiquidDepth2;
		}
		public float getRoadLiquidDepth3() {
			return roadLiquidDepth3;
		}
		public void setRoadLiquidDepth3(float roadLiquidDepth3) {
			this.roadLiquidDepth3 = roadLiquidDepth3;
		}
		public float getRoadLiquidDepth4() {
			return roadLiquidDepth4;
		}
		public void setRoadLiquidDepth4(float roadLiquidDepth4) {
			this.roadLiquidDepth4 = roadLiquidDepth4;
		}
		public short getRoadState1() {
			return roadState1;
		}
		public void setRoadState1(short roadState1) {
			this.roadState1 = roadState1;
		}
		public short getRoadState2() {
			return roadState2;
		}
		public void setRoadState2(short roadState2) {
			this.roadState2 = roadState2;
		}
		public short getRoadState3() {
			return roadState3;
		}
		public void setRoadState3(short roadState3) {
			this.roadState3 = roadState3;
		}
		public short getRoadState4() {
			return roadState4;
		}
		public void setRoadState4(short roadState4) {
			this.roadState4 = roadState4;
		}
		public float getRoadSubSurfaceTemp1() {
			return roadSubSurfaceTemp1;
		}
		public void setRoadSubSurfaceTemp1(float roadSubSurfaceTemp1) {
			this.roadSubSurfaceTemp1 = roadSubSurfaceTemp1;
		}
		public float getRoadSubSurfaceTemp2() {
			return roadSubSurfaceTemp2;
		}
		public void setRoadSubSurfaceTemp2(float roadSubSurfaceTemp2) {
			this.roadSubSurfaceTemp2 = roadSubSurfaceTemp2;
		}
		public float getRoadSubSurfaceTemp3() {
			return roadSubSurfaceTemp3;
		}
		public void setRoadSubSurfaceTemp3(float roadSubSurfaceTemp3) {
			this.roadSubSurfaceTemp3 = roadSubSurfaceTemp3;
		}
		public float getRoadSubSurfaceTemp4() {
			return roadSubSurfaceTemp4;
		}
		public void setRoadSubSurfaceTemp4(float roadSubSurfaceTemp4) {
			this.roadSubSurfaceTemp4 = roadSubSurfaceTemp4;
		}
		public float getFuelTemperature() {
			return fuelTemperature;
		}
		public void setFuelTemperature(float fuelTemperature) {
			this.fuelTemperature = fuelTemperature;
		}
		public double getFuelTempChangeTime() {
			return fuelTempChangeTime;
		}
		public void setFuelTempChangeTime(double fuelTempChangeTime) {
			this.fuelTempChangeTime = fuelTempChangeTime;
		}
		public float getFuelMoisture() {
			return fuelMoisture;
		}
		public void setFuelMoisture(float fuelMoisture) {
			this.fuelMoisture = fuelMoisture;
		}
		public double getFuelMoistChangeTime() {
			return fuelMoistChangeTime;
		}
		public void setFuelMoistChangeTime(double fuelMoistChangeTime) {
			this.fuelMoistChangeTime = fuelMoistChangeTime;
		}
		public float getSoilTemperature() {
			return soilTemperature;
		}
		public void setSoilTemperature(float soilTemperature) {
			this.soilTemperature = soilTemperature;
		}
		public char getSoilTemperatureDD() {
			return soilTemperatureDD;
		}
		public void setSoilTemperatureDD(char soilTemperatureDD) {
			this.soilTemperatureDD = soilTemperatureDD;
		}
		public int getSoilTemperatureQCA() {
			return soilTemperatureQCA;
		}
		public void setSoilTemperatureQCA(int soilTemperatureQCA) {
			this.soilTemperatureQCA = soilTemperatureQCA;
		}
		public int getSoilTemperatureQCR() {
			return soilTemperatureQCR;
		}
		public void setSoilTemperatureQCR(int soilTemperatureQCR) {
			this.soilTemperatureQCR = soilTemperatureQCR;
		}
		public float getSoilTemperatureQCD() {
			return soilTemperatureQCD;
		}
		public void setSoilTemperatureQCD(float soilTemperatureQCD) {
			this.soilTemperatureQCD = soilTemperatureQCD;
		}
		public float getSoilMoisture() {
			return soilMoisture;
		}
		public void setSoilMoisture(float soilMoisture) {
			this.soilMoisture = soilMoisture;
		}
		public float getSoilMoisturePercent() {
			return soilMoisturePercent;
		}
		public void setSoilMoisturePercent(float soilMoisturePercent) {
			this.soilMoisturePercent = soilMoisturePercent;
		}
		public char getSoilMoisturePercentDD() {
			return soilMoisturePercentDD;
		}
		public void setSoilMoisturePercentDD(char soilMoisturePercentDD) {
			this.soilMoisturePercentDD = soilMoisturePercentDD;
		}
		public int getSoilMoisturePercentQCA() {
			return soilMoisturePercentQCA;
		}
		public void setSoilMoisturePercentQCA(int soilMoisturePercentQCA) {
			this.soilMoisturePercentQCA = soilMoisturePercentQCA;
		}
		public int getSoilMoisturePercentQCR() {
			return soilMoisturePercentQCR;
		}
		public void setSoilMoisturePercentQCR(int soilMoisturePercentQCR) {
			this.soilMoisturePercentQCR = soilMoisturePercentQCR;
		}
		public float getSoilMoisturePercentQCD() {
			return soilMoisturePercentQCD;
		}
		public void setSoilMoisturePercentQCD(float soilMoisturePercentQCD) {
			this.soilMoisturePercentQCD = soilMoisturePercentQCD;
		}
		public float getWaterLevel() {
			return waterLevel;
		}
		public void setWaterLevel(float waterLevel) {
			this.waterLevel = waterLevel;
		}
		public float getMobileLat() {
			return mobileLat;
		}
		public void setMobileLat(float mobileLat) {
			this.mobileLat = mobileLat;
		}
		public float getMobileLon() {
			return mobileLon;
		}
		public void setMobileLon(float mobileLon) {
			this.mobileLon = mobileLon;
		}
		public float getMobileElev() {
			return mobileElev;
		}
		public void setMobileElev(float mobileElev) {
			this.mobileElev = mobileElev;
		}

}

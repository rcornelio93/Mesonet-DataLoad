package com.mesonet.app;

import java.io.IOException;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.mesonet.data.StationWeatherDetails;

import ucar.nc2.NetcdfFile;
import ucar.nc2.Variable;
import ucar.nc2.Attribute;
import ucar.ma2.Array;
import ucar.ma2.Index;

public class LoadData {
	@SuppressWarnings("deprecation")
	public static void main(String args[]){
		String filename = "/Users/Rayan/Desktop/College/226-JohnGash/Project1-New/MesonetData/obs/2013/01-01/20130101_0100.gz";
		NetcdfFile ncfile = null;
		int i,j=0;
		 StationWeatherDetails[] weather = new StationWeatherDetails[90244];

		try {
			ncfile = NetcdfFile.open(filename);
			Variable var=null;
			java.util.List<Variable> variableList = ncfile.getVariables();
			Iterator<Variable> varIterator = variableList.iterator();
			while (varIterator.hasNext()) {
				var=varIterator.next();
				System.out.println("Name and Dimension:"+var.getNameAndDimensions());
				if ((var.getDescription()) == null){
					System.out.println("Null Description Skipping");
					continue;
				}
				System.out.println("Data for: "+var.getDescription());
				System.out.println("Dimensions string:"+var.getDimensionsString());
				if ((var.getName()).equalsIgnoreCase("providerId")){
					String providerIdString = "";
					Array providerIdArr = var.read();
					int rank= providerIdArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = providerIdArr.getShape();
					Index index = providerIdArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						for ( j=0; j<shape[1]; j++) {
							char dval = providerIdArr.getChar(index.set(i,j));
							providerIdString += dval;
							//System.out.print(dval);
						}
						System.out.println(providerIdString);
						providerIdString = providerIdString.replaceAll("\\u0000", "" ) ;  
					 	weather[i] = new StationWeatherDetails();
						weather[i].setProviderId(providerIdString);
						providerIdString = "";
					}

				}else if ((var.getName()).equalsIgnoreCase("stationId")){
					String stationIdString = "";
					Array stationIdArr = var.read();
					int rank= stationIdArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = stationIdArr.getShape();
					Index index = stationIdArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						for ( j=0; j<shape[1]; j++) {
							char dval = stationIdArr.getChar(index.set(i,j));
							stationIdString += dval;
							//System.out.print(dval);
						}
						System.out.println(stationIdString);
						stationIdString = stationIdString.replaceAll("\\u0000", "" ) ;  
						weather[i].setStationId(stationIdString);
						stationIdString = "";
					}
				}else if ((var.getName()).equalsIgnoreCase("handbook5Id")){
					String handbook5IdString = "";
					Array handbook5IdArr = var.read();
					int rank= handbook5IdArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = handbook5IdArr.getShape();
					Index index = handbook5IdArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						for ( j=0; j<shape[1]; j++) {
							char dval = handbook5IdArr.getChar(index.set(i,j));
							handbook5IdString += dval;
							//System.out.print(dval);
						}
						System.out.println(handbook5IdString);
						handbook5IdString = handbook5IdString.replaceAll("\\u0000", "" ) ;  
						weather[i].setHandbook5Id(handbook5IdString);
						handbook5IdString = "";
					}
				}else if ((var.getName()).equalsIgnoreCase("stationName")){
					String stationNameString = "";
					Array stationNameArr = var.read();
					int rank= stationNameArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = stationNameArr.getShape();
					Index index = stationNameArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						for ( j=0; j<shape[1]; j++) {
							char dval = stationNameArr.getChar(index.set(i,j));
							stationNameString += dval;
							//System.out.print(dval);
						}
						System.out.println(stationNameString);
						stationNameString = stationNameString.replaceAll("\\u0000", "" ) ;  
						weather[i].setStationName(stationNameString);
						stationNameString = "";
					}
				}else if ((var.getName()).equalsIgnoreCase("homeWFO")){
					String homeWFOString = "";
					Array homeWFOArr = var.read();
					int rank= homeWFOArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = homeWFOArr.getShape();
					Index index = homeWFOArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						for ( j=0; j<shape[1]; j++) {
							char dval = homeWFOArr.getChar(index.set(i,j));
							homeWFOString += dval;
							//System.out.print(dval);
						}
						System.out.println(homeWFOString);
						homeWFOString = homeWFOString.replaceAll("\\u0000", "" ) ;  
						weather[i].setHomeWFO(homeWFOString);
						homeWFOString = "";
					}
				}else if ((var.getName()).equalsIgnoreCase("numericWMOid")){
					int numericWMOid = 0;
					Array homeWFOArr = var.read();
					int rank= homeWFOArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = homeWFOArr.getShape();
					Index index = homeWFOArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						numericWMOid = homeWFOArr.getInt(index.set(i));
						weather[i].setNumericWMOid(numericWMOid);
						System.out.println(numericWMOid);
						numericWMOid =0;
					}
				}else if ((var.getName()).equalsIgnoreCase("stationType")){
					String stationTypeString = "";
					Array stationTypeArr = var.read();
					int rank= stationTypeArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = stationTypeArr.getShape();
					Index index = stationTypeArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						for ( j=0; j<shape[1]; j++) {
							char dval = stationTypeArr.getChar(index.set(i,j));
							stationTypeString += dval;
							//System.out.print(dval);
						}
						System.out.println(stationTypeString);
						stationTypeString = stationTypeString.replaceAll("\\u0000", "" ) ;  
						weather[i].setStationType(stationTypeString);
						stationTypeString = "";
					}
				}else if ((var.getName()).equalsIgnoreCase("dataProvider")){
					String dataProviderString = "";
					Array dataProviderArr = var.read();
					int rank= dataProviderArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = dataProviderArr.getShape();
					Index index = dataProviderArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						for ( j=0; j<shape[1]; j++) {
							char dval = dataProviderArr.getChar(index.set(i,j));
							dataProviderString += dval;
							//System.out.print(dval);
						}
						System.out.println(dataProviderString);
						dataProviderString = dataProviderString.replaceAll("\\u0000", "" ) ;  
						weather[i].setDataProvider(dataProviderString);
						dataProviderString = "";
					}
				} else if((var.getName()).equalsIgnoreCase("longitude")){
					Array longitudeArr = var.read();
					int rank= longitudeArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = longitudeArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = longitudeArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float longitude = longitudeArr.getFloat(index.set(i));
						System.out.print(longitude);
						weather[i].setLongitude(longitude);
						System.out.println("");
					}

				}else if((var.getName()).equalsIgnoreCase("latitude")){
					Array latitudeArr = var.read();
					int rank= latitudeArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = latitudeArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = latitudeArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float latitude = latitudeArr.getFloat(index.set(i));
						System.out.print(latitude);
						weather[i].setLatitude(latitude);
						System.out.println("");
					}

				}else if((var.getName()).equalsIgnoreCase("elevation")){
					Array elevationArr = var.read();
					int rank= elevationArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = elevationArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = elevationArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float elevation = elevationArr.getFloat(index.set(i));
						System.out.print(elevation);
						weather[i].setElevation(elevation);
						System.out.println("");
					}

				}else if((var.getName()).equalsIgnoreCase("observationTime")){
					Array observationTimeArr = var.read();
					int rank= observationTimeArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = observationTimeArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = observationTimeArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						double observationTime = observationTimeArr.getDouble(index.set(i));
						weather[i].setObservationTime(observationTime);
						System.out.println(observationTime);
					}

				}else if((var.getName()).equalsIgnoreCase("reportTime")){
					Array reportTimeArr = var.read();
					int rank= reportTimeArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = reportTimeArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = reportTimeArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						double reportTime = reportTimeArr.getDouble(index.set(i));
						weather[i].setReportTime(reportTime);
						System.out.println(reportTime);
					}

				}else if((var.getName()).equalsIgnoreCase("receivedTime")){
					Array receivedTimeArr = var.read();
					int rank= receivedTimeArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = receivedTimeArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = receivedTimeArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						double receivedTime = receivedTimeArr.getDouble(index.set(i));
						weather[i].setReceivedTime(receivedTime);
						System.out.println(receivedTime);
					}

				}else if((var.getName()).equalsIgnoreCase("temperature")){
					Array temperatureArr = var.read();
					int rank= temperatureArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = temperatureArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = temperatureArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float temperature = temperatureArr.getFloat(index.set(i));
						weather[i].setTemperature(temperature);
						System.out.println(temperature);
					}
				}else if((var.getName()).equalsIgnoreCase("tempChangeTime")){
					Array tempChangeTimeArr = var.read();
					int rank= tempChangeTimeArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = tempChangeTimeArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = tempChangeTimeArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						double tempChangeTime = tempChangeTimeArr.getDouble(index.set(i));
						weather[i].setTempChangeTime(tempChangeTime);
						System.out.println(tempChangeTime);
					}
				}else if ((var.getName()).equalsIgnoreCase("temperatureDD")){
					Array temperatureDDArr = var.read();
					int rank= temperatureDDArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = temperatureDDArr.getShape();
					Index index = temperatureDDArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
							char dval = temperatureDDArr.getChar(index.set(i));
							weather[i].setTemperatureDD(dval);
						System.out.println(dval);
					}
				} else if((var.getName()).equalsIgnoreCase("temperatureQCA")){
					Array temperatureQCAArr = var.read();
					int rank= temperatureQCAArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = temperatureQCAArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = temperatureQCAArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int temperatureQCA = temperatureQCAArr.getInt(index.set(i));
						weather[i].setTemperatureQCA(temperatureQCA);
						System.out.println(temperatureQCA);
					}
				}else if((var.getName()).equalsIgnoreCase("temperatureQCR")){
					Array temperatureQCRArr = var.read();
					int rank= temperatureQCRArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = temperatureQCRArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = temperatureQCRArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int temperatureQCR = temperatureQCRArr.getInt(index.set(i));
						weather[i].setTemperatureQCR(temperatureQCR);
						System.out.println(temperatureQCR);
					}
				}else if((var.getName()).equalsIgnoreCase("temperatureQCD")){
					Array temperatureQCDArr = var.read();
					int rank= temperatureQCDArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = temperatureQCDArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = temperatureQCDArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float temperatureQCD = temperatureQCDArr.getFloat(index.set(i));
						weather[i].setTemperatureQCD(temperatureQCD);
						System.out.println(temperatureQCD);
					}
				}else if((var.getName()).equalsIgnoreCase("temperatureICA")){
					Array temperatureICAArr = var.read();
					int rank= temperatureICAArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = temperatureICAArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = temperatureICAArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int temperatureICA = temperatureICAArr.getInt(index.set(i));
						weather[i].setTemperatureICA(temperatureICA);
						System.out.println(temperatureICA);
					}
				}else if((var.getName()).equalsIgnoreCase("temperatureICR")){
					Array temperatureICRArr = var.read();
					int rank= temperatureICRArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = temperatureICRArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = temperatureICRArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int temperatureICR = temperatureICRArr.getInt(index.set(i));
						weather[i].setTemperatureICR(temperatureICR);
						System.out.println(temperatureICR);
					}
				}else if((var.getName()).equalsIgnoreCase("dewpoint")){
					Array dewpointArr = var.read();
					int rank= dewpointArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = dewpointArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = dewpointArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float dewpoint = dewpointArr.getFloat(index.set(i));
						weather[i].setDewpoint(dewpoint);
						System.out.println(dewpoint);
					}
				}else if ((var.getName()).equalsIgnoreCase("dewpointDD")){
					Array dewpointDDArr = var.read();
					int rank= dewpointDDArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = dewpointDDArr.getShape();
					Index index = dewpointDDArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
							char dval = dewpointDDArr.getChar(index.set(i));
							weather[i].setDewpointDD(dval);
						System.out.println(dval);
					}
				} else if((var.getName()).equalsIgnoreCase("dewpointQCA")){
					Array dewpointQCAArr = var.read();
					int rank= dewpointQCAArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = dewpointQCAArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = dewpointQCAArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int dewpointQCA = dewpointQCAArr.getInt(index.set(i));
						weather[i].setDewpointQCA(dewpointQCA);
						System.out.println(dewpointQCA);
					}
				}else if((var.getName()).equalsIgnoreCase("dewpointQCR")){
					Array dewpointQCRArr = var.read();
					int rank= dewpointQCRArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = dewpointQCRArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = dewpointQCRArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int dewpointQCR = dewpointQCRArr.getInt(index.set(i));
						weather[i].setDewpointQCR(dewpointQCR);
						System.out.println(dewpointQCR);
					}
				}else if((var.getName()).equalsIgnoreCase("dewpointQCD")){
					Array dewpointQCDArr = var.read();
					int rank= dewpointQCDArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = dewpointQCDArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = dewpointQCDArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float dewpointQCD = dewpointQCDArr.getFloat(index.set(i));
						weather[i].setDewpointQCD(dewpointQCD);
						System.out.println(dewpointQCD);
					}
				}else if((var.getName()).equalsIgnoreCase("dewpointICA")){
					Array dewpointICAArr = var.read();
					int rank= dewpointICAArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = dewpointICAArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = dewpointICAArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int dewpointICA = dewpointICAArr.getInt(index.set(i));
						weather[i].setDewpointICA(dewpointICA);
						System.out.println(dewpointICA);
					}
				}else if((var.getName()).equalsIgnoreCase("dewpointICR")){
					Array dewpointICRArr = var.read();
					int rank= dewpointICRArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = dewpointICRArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = dewpointICRArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int dewpointICR = dewpointICRArr.getInt(index.set(i));
						weather[i].setDewpointICR(dewpointICR);
						System.out.println(dewpointICR);
					}
				}else if((var.getName()).equalsIgnoreCase("relHumidity")){
					Array relHumidityArr = var.read();
					int rank= relHumidityArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = relHumidityArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = relHumidityArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float relHumidity = relHumidityArr.getFloat(index.set(i));
						weather[i].setRelHumidity(relHumidity);
						System.out.println(relHumidity);
					}
				}else if((var.getName()).equalsIgnoreCase("rhChangeTime")){
					Array rhChangeTimeArr = var.read();
					int rank= rhChangeTimeArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = rhChangeTimeArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = rhChangeTimeArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						double rhChangeTime = rhChangeTimeArr.getDouble(index.set(i));
						weather[i].setRhChangetime(rhChangeTime);
						System.out.println(rhChangeTime);
					}
				}else if ((var.getName()).equalsIgnoreCase("relHumidityDD")){
					Array relHumidityDDArr = var.read();
					int rank= relHumidityDDArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = relHumidityDDArr.getShape();
					Index index = relHumidityDDArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
							char dval = relHumidityDDArr.getChar(index.set(i));
							weather[i].setRelHumidityDD(dval);
						System.out.println(dval);
					}
				} else if((var.getName()).equalsIgnoreCase("relHumidityQCA")){
					Array relHumidityQCAArr = var.read();
					int rank= relHumidityQCAArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = relHumidityQCAArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = relHumidityQCAArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int relHumidityQCA = relHumidityQCAArr.getInt(index.set(i));
						weather[i].setRelHumidityQCA(relHumidityQCA);
						System.out.println(relHumidityQCA);
					}
				}else if((var.getName()).equalsIgnoreCase("relHumidityQCR")){
					Array relHumidityQCRArr = var.read();
					int rank= relHumidityQCRArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = relHumidityQCRArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = relHumidityQCRArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int relHumidityQCR = relHumidityQCRArr.getInt(index.set(i));
						weather[i].setRelHumidityQCR(relHumidityQCR);
						System.out.println(relHumidityQCR);
					}
				}else if((var.getName()).equalsIgnoreCase("relHumidityQCD")){
					Array relHumidityQCDArr = var.read();
					int rank= relHumidityQCDArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = relHumidityQCDArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = relHumidityQCDArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float relHumidityQCD = relHumidityQCDArr.getFloat(index.set(i));
						weather[i].setRelHumidityQCD(relHumidityQCD);
						System.out.println(relHumidityQCD);
					}
				}else if((var.getName()).equalsIgnoreCase("stationPressure")){
					Array stationPressureArr = var.read();
					int rank= stationPressureArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = stationPressureArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = stationPressureArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float stationPressure = stationPressureArr.getFloat(index.set(i));
						weather[i].setStationPressure(stationPressure);
						System.out.println(stationPressure);
					}
				}else if((var.getName()).equalsIgnoreCase("stationPressChangeTime")){
					Array stationPressChangeTimeArr = var.read();
					int rank= stationPressChangeTimeArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = stationPressChangeTimeArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = stationPressChangeTimeArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						double stationPressChangeTime = stationPressChangeTimeArr.getDouble(index.set(i));
						weather[i].setStationPressChangeTime(stationPressChangeTime);
						System.out.println(stationPressChangeTime);
					}
				}else if ((var.getName()).equalsIgnoreCase("stationPressureDD")){
					Array stationPressureDDArr = var.read();
					int rank= stationPressureDDArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = stationPressureDDArr.getShape();
					Index index = stationPressureDDArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
							char stationPressureDD = stationPressureDDArr.getChar(index.set(i));
							weather[i].setStationPressureDD(stationPressureDD);
						System.out.println(stationPressureDD);
					}
				}else if((var.getName()).equalsIgnoreCase("stationPressureQCA")){
					Array stationPressureQCAArr = var.read();
					int rank= stationPressureQCAArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = stationPressureQCAArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = stationPressureQCAArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int stationPressureQCA = stationPressureQCAArr.getInt(index.set(i));
						weather[i].setStationPressureQCA(stationPressureQCA);
						System.out.println(stationPressureQCA);
					}
				}else if((var.getName()).equalsIgnoreCase("stationPressureQCR")){
					Array stationPressureQCRArr = var.read();
					int rank= stationPressureQCRArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = stationPressureQCRArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = stationPressureQCRArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int stationPressureQCR = stationPressureQCRArr.getInt(index.set(i));
						weather[i].setStationPressureQCR(stationPressureQCR);
						System.out.println(stationPressureQCR);
					}
				}else if((var.getName()).equalsIgnoreCase("stationPressureQCD")){
					Array stationPressureQCDArr = var.read();
					int rank= stationPressureQCDArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = stationPressureQCDArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = stationPressureQCDArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float stationPressureQCD = stationPressureQCDArr.getFloat(index.set(i));
						weather[i].setStationPressureQCD(stationPressureQCD);
						System.out.println(stationPressureQCD);
					}
				}else if((var.getName()).equalsIgnoreCase("stationPressureICA")){
					Array stationPressureICAArr = var.read();
					int rank= stationPressureICAArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = stationPressureICAArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = stationPressureICAArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int stationPressureICA = stationPressureICAArr.getInt(index.set(i));
						weather[i].setStationPressureICA(stationPressureICA);
						System.out.println(stationPressureICA);
					}
				}else if((var.getName()).equalsIgnoreCase("stationPressureICR")){
					Array stationPressureICRArr = var.read();
					int rank= stationPressureICRArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = stationPressureICRArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = stationPressureICRArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int stationPressureICR = stationPressureICRArr.getInt(index.set(i));
						weather[i].setStationPressureICR(stationPressureICR);
						System.out.println(stationPressureICR);
					}
				}else if((var.getName()).equalsIgnoreCase("seaLevelPressure")){
					Array seaLevelPressureArr = var.read();
					int rank= seaLevelPressureArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = seaLevelPressureArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = seaLevelPressureArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float seaLevelPressure = seaLevelPressureArr.getFloat(index.set(i));
						weather[i].setSeaLevelPressure(seaLevelPressure);
						System.out.println(seaLevelPressure);
					}
				}else if ((var.getName()).equalsIgnoreCase("seaLevelPressureDD")){
					Array seaLevelPressureDDArr = var.read();
					int rank= seaLevelPressureDDArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = seaLevelPressureDDArr.getShape();
					Index index = seaLevelPressureDDArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
							char seaLevelPressureDD = seaLevelPressureDDArr.getChar(index.set(i));
							weather[i].setSeaLevelPressureDD(seaLevelPressureDD);
						System.out.println(seaLevelPressureDD);
					}
				}else if((var.getName()).equalsIgnoreCase("seaLevelPressureQCA")){
					Array seaLevelPressureQCAArr = var.read();
					int rank= seaLevelPressureQCAArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = seaLevelPressureQCAArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = seaLevelPressureQCAArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int seaLevelPressureQCA = seaLevelPressureQCAArr.getInt(index.set(i));
						weather[i].setSeaLevelPressureQCA(seaLevelPressureQCA);
						System.out.println(seaLevelPressureQCA);
					}
				}else if((var.getName()).equalsIgnoreCase("seaLevelPressureQCR")){
					Array seaLevelPressureQCRArr = var.read();
					int rank= seaLevelPressureQCRArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = seaLevelPressureQCRArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = seaLevelPressureQCRArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int seaLevelPressureQCR = seaLevelPressureQCRArr.getInt(index.set(i));
						weather[i].setSeaLevelPressureQCR(seaLevelPressureQCR);
						System.out.println(seaLevelPressureQCR);
					}
				}else if((var.getName()).equalsIgnoreCase("seaLevelPressureQCD")){
					Array seaLevelPressureQCDArr = var.read();
					int rank= seaLevelPressureQCDArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = seaLevelPressureQCDArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = seaLevelPressureQCDArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float seaLevelPressureQCD = seaLevelPressureQCDArr.getFloat(index.set(i));
						weather[i].setSeaLevelPressureQCD(seaLevelPressureQCD);
						System.out.println(seaLevelPressureQCD);
					}
				}else if((var.getName()).equalsIgnoreCase("seaLevelPressureICA")){
					Array seaLevelPressureICAArr = var.read();
					int rank= seaLevelPressureICAArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = seaLevelPressureICAArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = seaLevelPressureICAArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int seaLevelPressureICA = seaLevelPressureICAArr.getInt(index.set(i));
						weather[i].setSeaLevelPressureICA(seaLevelPressureICA);
						System.out.println(seaLevelPressureICA);
					}
				}else if((var.getName()).equalsIgnoreCase("seaLevelPressureICR")){
					Array seaLevelPressureICRArr = var.read();
					int rank= seaLevelPressureICRArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = seaLevelPressureICRArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = seaLevelPressureICRArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int seaLevelPressureICR = seaLevelPressureICRArr.getInt(index.set(i));
						weather[i].setSeaLevelPressureICR(seaLevelPressureICR);
						System.out.println(seaLevelPressureICR);
					}
				}else if((var.getName()).equalsIgnoreCase("pressChangeChar")){
					Array pressChangeCharArr = var.read();
					int rank= pressChangeCharArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = pressChangeCharArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = pressChangeCharArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						short pressChangeChar = pressChangeCharArr.getShort(index.set(i));
						weather[i].setPressChangeChar(pressChangeChar);
						System.out.println(pressChangeChar);
					}
				}else if((var.getName()).equalsIgnoreCase("pressChange3Hour")){
					Array pressChange3HourArr = var.read();
					int rank= pressChange3HourArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = pressChange3HourArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = pressChange3HourArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float pressChange3Hour = pressChange3HourArr.getFloat(index.set(i));
						weather[i].setPressChange3Hour(pressChange3Hour);
						System.out.println(pressChange3Hour);
					}
				}else if ((var.getName()).equalsIgnoreCase("pressChange3HourDD")){
					Array pressChange3HourDDArr = var.read();
					int rank= pressChange3HourDDArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = pressChange3HourDDArr.getShape();
					Index index = pressChange3HourDDArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
							char pressChange3HourDD = pressChange3HourDDArr.getChar(index.set(i));
							weather[i].setPressChange3HourDD(pressChange3HourDD);
						System.out.println(pressChange3HourDD);
					}
				}else if((var.getName()).equalsIgnoreCase("pressChange3HourQCA")){
					Array pressChange3HourQCAArr = var.read();
					int rank= pressChange3HourQCAArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = pressChange3HourQCAArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = pressChange3HourQCAArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int pressChange3HourQCA = pressChange3HourQCAArr.getInt(index.set(i));
						weather[i].setPressChange3HourQCA(pressChange3HourQCA);
						System.out.println(pressChange3HourQCA);
					}
				}else if((var.getName()).equalsIgnoreCase("pressChange3HourQCR")){
					Array pressChange3HourQCRArr = var.read();
					int rank= pressChange3HourQCRArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = pressChange3HourQCRArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = pressChange3HourQCRArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int pressChange3HourQCR = pressChange3HourQCRArr.getInt(index.set(i));
						weather[i].setPressChange3HourQCR(pressChange3HourQCR);
						System.out.println(pressChange3HourQCR);
					}
				}else if((var.getName()).equalsIgnoreCase("pressChange3HourQCD")){
					Array pressChange3HourQCDArr = var.read();
					int rank= pressChange3HourQCDArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = pressChange3HourQCDArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = pressChange3HourQCDArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float pressChange3HourQCD = pressChange3HourQCDArr.getFloat(index.set(i));
						weather[i].setPressChange3HourQCD(pressChange3HourQCD);
						System.out.println(pressChange3HourQCD);
					}
				}else if((var.getName()).equalsIgnoreCase("pressChange3HourICA")){
					Array pressChange3HourICAArr = var.read();
					int rank= pressChange3HourICAArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = pressChange3HourICAArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = pressChange3HourICAArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int pressChange3HourICA = pressChange3HourICAArr.getInt(index.set(i));
						weather[i].setPressChange3HourICA(pressChange3HourICA);
						System.out.println(pressChange3HourICA);
					}
				}else if((var.getName()).equalsIgnoreCase("pressChange3HourICR")){
					Array pressChange3HourICRArr = var.read();
					int rank= pressChange3HourICRArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = pressChange3HourICRArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = pressChange3HourICRArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int pressChange3HourICR = pressChange3HourICRArr.getInt(index.set(i));
						weather[i].setPressChange3HourICR(pressChange3HourICR);
						System.out.println(pressChange3HourICR);
					}
				}else if((var.getName()).equalsIgnoreCase("altimeter")){
					Array altimeterArr = var.read();
					int rank= altimeterArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = altimeterArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = altimeterArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float altimeter = altimeterArr.getFloat(index.set(i));
						weather[i].setAltimeter(altimeter);
						System.out.println(altimeter);
					}
				}else if ((var.getName()).equalsIgnoreCase("altimeterDD")){
					Array altimeterDDArr = var.read();
					int rank= altimeterDDArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = altimeterDDArr.getShape();
					Index index = altimeterDDArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
							char altimeterDD = altimeterDDArr.getChar(index.set(i));
							weather[i].setAltimeterDD(altimeterDD);
						System.out.println(altimeterDD);
					}
				}else if((var.getName()).equalsIgnoreCase("altimeterQCA")){
					Array altimeterQCAArr = var.read();
					int rank= altimeterQCAArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = altimeterQCAArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = altimeterQCAArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int altimeterQCA = altimeterQCAArr.getInt(index.set(i));
						weather[i].setAltimeterQCA(altimeterQCA);
						System.out.println(altimeterQCA);
					}
				}else if((var.getName()).equalsIgnoreCase("altimeterQCR")){
					Array altimeterQCRArr = var.read();
					int rank= altimeterQCRArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = altimeterQCRArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = altimeterQCRArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int altimeterQCR = altimeterQCRArr.getInt(index.set(i));
						weather[i].setAltimeterQCR(altimeterQCR);
						System.out.println(altimeterQCR);
					}
				}else if((var.getName()).equalsIgnoreCase("altimeterQCD")){
					Array altimeterQCDArr = var.read();
					int rank= altimeterQCDArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = altimeterQCDArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = altimeterQCDArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float altimeterQCD = altimeterQCDArr.getFloat(index.set(i));
						weather[i].setAltimeterQCD(altimeterQCD);
						System.out.println(altimeterQCD);
					}
				}else if((var.getName()).equalsIgnoreCase("windDir")){
					Array windDirArr = var.read();
					int rank= windDirArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = windDirArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = windDirArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float windDir = windDirArr.getFloat(index.set(i));
						weather[i].setWindDir(windDir);
						System.out.println(windDir);
					}
				}else if((var.getName()).equalsIgnoreCase("windDirChangeTime")){
					Array windDirChangeTimeArr = var.read();
					int rank= windDirChangeTimeArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = windDirChangeTimeArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = windDirChangeTimeArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						double windDirChangeTime = windDirChangeTimeArr.getDouble(index.set(i));
						weather[i].setWindDirChangeTime(windDirChangeTime);
						System.out.println(windDirChangeTime);
					}
				}else if ((var.getName()).equalsIgnoreCase("windDirDD")){
					Array windDirDDArr = var.read();
					int rank= windDirDDArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = windDirDDArr.getShape();
					Index index = windDirDDArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
							char windDirDD = windDirDDArr.getChar(index.set(i));
							weather[i].setWindDirDD(windDirDD);
						System.out.println(windDirDD);
					}
				}else if((var.getName()).equalsIgnoreCase("windDirQCA")){
					Array windDirQCAArr = var.read();
					int rank= windDirQCAArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = windDirQCAArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = windDirQCAArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int windDirQCA = windDirQCAArr.getInt(index.set(i));
						weather[i].setWindDirQCA(windDirQCA);
						System.out.println(windDirQCA);
					}
				}else if((var.getName()).equalsIgnoreCase("windDirQCR")){
					Array windDirQCRArr = var.read();
					int rank= windDirQCRArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = windDirQCRArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = windDirQCRArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int windDirQCR = windDirQCRArr.getInt(index.set(i));
						weather[i].setWindDirQCR(windDirQCR);
						System.out.println(windDirQCR);
					}
				}else if((var.getName()).equalsIgnoreCase("windDirQCD")){
					Array windDirQCDArr = var.read();
					int rank= windDirQCDArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = windDirQCDArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = windDirQCDArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float windDirQCD = windDirQCDArr.getFloat(index.set(i));
						weather[i].setWindDirQCD(windDirQCD);
						System.out.println(windDirQCD);
					}
				}else if((var.getName()).equalsIgnoreCase("windDirICA")){
					Array windDirICAArr = var.read();
					int rank= windDirICAArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = windDirICAArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = windDirICAArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int windDirICA = windDirICAArr.getInt(index.set(i));
						weather[i].setWindDirICA(windDirICA);
						System.out.println(windDirICA);
					}
				}else if((var.getName()).equalsIgnoreCase("windDirICR")){
					Array windDirICRArr = var.read();
					int rank= windDirICRArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = windDirICRArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = windDirICRArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int windDirICR = windDirICRArr.getInt(index.set(i));
						weather[i].setWindDirICR(windDirICR);
						System.out.println(windDirICR);
					}
				}else if((var.getName()).equalsIgnoreCase("windSpeed")){
					Array windSpeedArr = var.read();
					int rank= windSpeedArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = windSpeedArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = windSpeedArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float windSpeed = windSpeedArr.getFloat(index.set(i));
						weather[i].setWindSpeed(windSpeed);
						System.out.println(windSpeed);
					}
				}else if((var.getName()).equalsIgnoreCase("windSpeedChangeTime")){
					Array windSpeedChangeTimeArr = var.read();
					int rank= windSpeedChangeTimeArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = windSpeedChangeTimeArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = windSpeedChangeTimeArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						double windSpeedChangeTime = windSpeedChangeTimeArr.getDouble(index.set(i));
						weather[i].setWindSpeedChangeTime(windSpeedChangeTime);
						System.out.println(windSpeedChangeTime);
					}
				}else if ((var.getName()).equalsIgnoreCase("windSpeedDD")){
					Array windSpeedDDArr = var.read();
					int rank= windSpeedDDArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = windSpeedDDArr.getShape();
					Index index = windSpeedDDArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
							char windSpeedDD = windSpeedDDArr.getChar(index.set(i));
							weather[i].setWindSpeedDD(windSpeedDD);
						System.out.println(windSpeedDD);
					}
				}else if((var.getName()).equalsIgnoreCase("windSpeedQCA")){
					Array windSpeedQCAArr = var.read();
					int rank= windSpeedQCAArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = windSpeedQCAArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = windSpeedQCAArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int windSpeedQCA = windSpeedQCAArr.getInt(index.set(i));
						weather[i].setWindSpeedQCA(windSpeedQCA);
						System.out.println(windSpeedQCA);
					}
				}else if((var.getName()).equalsIgnoreCase("windSpeedQCR")){
					Array windSpeedQCRArr = var.read();
					int rank= windSpeedQCRArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = windSpeedQCRArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = windSpeedQCRArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int windSpeedQCR = windSpeedQCRArr.getInt(index.set(i));
						weather[i].setWindSpeedQCR(windSpeedQCR);
						System.out.println(windSpeedQCR);
					}
				}else if((var.getName()).equalsIgnoreCase("windSpeedQCD")){
					Array windSpeedQCDArr = var.read();
					int rank= windSpeedQCDArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = windSpeedQCDArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = windSpeedQCDArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float windSpeedQCD = windSpeedQCDArr.getFloat(index.set(i));
						weather[i].setWindSpeedQCD(windSpeedQCD);
						System.out.println(windSpeedQCD);
					}
				}else if((var.getName()).equalsIgnoreCase("windSpeedICA")){
					Array windSpeedICAArr = var.read();
					int rank= windSpeedICAArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = windSpeedICAArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = windSpeedICAArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int windSpeedICA = windSpeedICAArr.getInt(index.set(i));
						weather[i].setWindSpeedICA(windSpeedICA);
						System.out.println(windSpeedICA);
					}
				}else if((var.getName()).equalsIgnoreCase("windSpeedICR")){
					Array windSpeedICRArr = var.read();
					int rank= windSpeedICRArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = windSpeedICRArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = windSpeedICRArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int windSpeedICR = windSpeedICRArr.getInt(index.set(i));
						weather[i].setWindSpeedICR(windSpeedICR);
						System.out.println(windSpeedICR);
					}
				}else if((var.getName()).equalsIgnoreCase("windGust")){
					Array windGustArr = var.read();
					int rank= windGustArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = windGustArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = windGustArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float windGust = windGustArr.getFloat(index.set(i));
						weather[i].setWindGust(windGust);
						System.out.println(windGust);
					}
				}else if((var.getName()).equalsIgnoreCase("windGustChangeTime")){
					Array windGustChangeTimeArr = var.read();
					int rank= windGustChangeTimeArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = windGustChangeTimeArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = windGustChangeTimeArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						double windGustChangeTime = windGustChangeTimeArr.getDouble(index.set(i));
						weather[i].setWindGustChangeTime(windGustChangeTime);
						System.out.println(windGustChangeTime);
					}
				}else if ((var.getName()).equalsIgnoreCase("windGustDD")){
					Array windGustDDArr = var.read();
					int rank= windGustDDArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = windGustDDArr.getShape();
					Index index = windGustDDArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
							char windGustDD = windGustDDArr.getChar(index.set(i));
							weather[i].setWindGustDD(windGustDD);
						System.out.println(windGustDD);
					}
				}else if((var.getName()).equalsIgnoreCase("windGustQCA")){
					Array windGustQCAArr = var.read();
					int rank= windGustQCAArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = windGustQCAArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = windGustQCAArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int windGustQCA = windGustQCAArr.getInt(index.set(i));
						weather[i].setWindGustQCA(windGustQCA);
						System.out.println(windGustQCA);
					}
				}else if((var.getName()).equalsIgnoreCase("windGustQCR")){
					Array windGustQCRArr = var.read();
					int rank= windGustQCRArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = windGustQCRArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = windGustQCRArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int windGustQCR = windGustQCRArr.getInt(index.set(i));
						weather[i].setWindGustQCR(windGustQCR);
						System.out.println(windGustQCR);
					}
				}else if((var.getName()).equalsIgnoreCase("windGustQCD")){
					Array windGustQCDArr = var.read();
					int rank= windGustQCDArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = windGustQCDArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = windGustQCDArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float windGustQCD = windGustQCDArr.getFloat(index.set(i));
						weather[i].setWindGustQCD(windGustQCD);
						System.out.println(windGustQCD);
					}
				}else if((var.getName()).equalsIgnoreCase("windDirMax")){
					Array windDirMaxArr = var.read();
					int rank= windDirMaxArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = windDirMaxArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = windDirMaxArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float windDirMax = windDirMaxArr.getFloat(index.set(i));
						weather[i].setWindDirMax(windDirMax);
						System.out.println(windDirMax);
					}
				}else if ((var.getName()).equalsIgnoreCase("windDirMaxDD")){
					Array windDirMaxDDArr = var.read();
					int rank= windDirMaxDDArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = windDirMaxDDArr.getShape();
					Index index = windDirMaxDDArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
							char windDirMaxDD = windDirMaxDDArr.getChar(index.set(i));
							weather[i].setWindDirMaxDD(windDirMaxDD);
						System.out.println(windDirMaxDD);
					}
				}else if((var.getName()).equalsIgnoreCase("windDirMaxQCA")){
					Array windDirMaxQCAArr = var.read();
					int rank= windDirMaxQCAArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = windDirMaxQCAArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = windDirMaxQCAArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int windDirMaxQCA = windDirMaxQCAArr.getInt(index.set(i));
						weather[i].setWindDirMaxQCA(windDirMaxQCA);
						System.out.println(windDirMaxQCA);
					}
				}else if((var.getName()).equalsIgnoreCase("windDirMaxQCR")){
					Array windDirMaxQCRArr = var.read();
					int rank= windDirMaxQCRArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = windDirMaxQCRArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = windDirMaxQCRArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int windDirMaxQCR = windDirMaxQCRArr.getInt(index.set(i));
						weather[i].setWindDirMaxQCR(windDirMaxQCR);
						System.out.println(windDirMaxQCR);
					}
				}else if((var.getName()).equalsIgnoreCase("windDirMaxQCD")){
					Array windDirMaxQCDArr = var.read();
					int rank= windDirMaxQCDArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = windDirMaxQCDArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = windDirMaxQCDArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float windDirMaxQCD = windDirMaxQCDArr.getFloat(index.set(i));
						weather[i].setWindDirMaxQCD(windDirMaxQCD);
						System.out.println(windDirMaxQCD);
					}
				}else if((var.getName()).equalsIgnoreCase("visibility")){
					Array visibilityArr = var.read();
					int rank= visibilityArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = visibilityArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = visibilityArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float visibility = visibilityArr.getFloat(index.set(i));
						weather[i].setVisibility(visibility);
						System.out.println(visibility);
					}
				}else if ((var.getName()).equalsIgnoreCase("visibilityDD")){
					Array visibilityDDArr = var.read();
					int rank= visibilityDDArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = visibilityDDArr.getShape();
					Index index = visibilityDDArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
							char visibilityDD = visibilityDDArr.getChar(index.set(i));
							weather[i].setVisibilityDD(visibilityDD);
						System.out.println(visibilityDD);
					}
				}else if((var.getName()).equalsIgnoreCase("visibilityQCA")){
					Array visibilityQCAArr = var.read();
					int rank= visibilityQCAArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = visibilityQCAArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = visibilityQCAArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int visibilityQCA = visibilityQCAArr.getInt(index.set(i));
						weather[i].setVisibilityQCA(visibilityQCA);
						System.out.println(visibilityQCA);
					}
				}else if((var.getName()).equalsIgnoreCase("visibilityQCR")){
					Array visibilityQCRArr = var.read();
					int rank= visibilityQCRArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = visibilityQCRArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = visibilityQCRArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int visibilityQCR = visibilityQCRArr.getInt(index.set(i));
						weather[i].setVisibilityQCR(visibilityQCR);
						System.out.println(visibilityQCR);
					}
				}else if((var.getName()).equalsIgnoreCase("visibilityQCD")){
					Array visibilityQCDArr = var.read();
					int rank= visibilityQCDArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = visibilityQCDArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = visibilityQCDArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float visibilityQCD = visibilityQCDArr.getFloat(index.set(i));
						weather[i].setVisibilityQCD(visibilityQCD);
						System.out.println(visibilityQCD);
					}
				}else if((var.getName()).equalsIgnoreCase("visibilityICA")){
					Array visibilityICAArr = var.read();
					int rank= visibilityICAArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = visibilityICAArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = visibilityICAArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int visibilityICA = visibilityICAArr.getInt(index.set(i));
						weather[i].setVisibilityICA(visibilityICA);
						System.out.println(visibilityICA);
					}
				}else if((var.getName()).equalsIgnoreCase("visibilityICR")){
					Array visibilityICRArr = var.read();
					int rank= visibilityICRArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = visibilityICRArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = visibilityICRArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int visibilityICR = visibilityICRArr.getInt(index.set(i));
						weather[i].setVisibilityICR(visibilityICR);
						System.out.println(visibilityICR);
					}
				}else if((var.getName()).equalsIgnoreCase("rawPrecip")){
					Array rawPrecipArr = var.read();
					int rank= rawPrecipArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = rawPrecipArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = rawPrecipArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float rawPrecip = rawPrecipArr.getFloat(index.set(i));
						weather[i].setRawPrecip(rawPrecip);
						System.out.println(rawPrecip);
					}
				}else if((var.getName()).equalsIgnoreCase("precipAccum")){
					Array precipAccumArr = var.read();
					int rank= precipAccumArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = precipAccumArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = precipAccumArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float precipAccum = precipAccumArr.getFloat(index.set(i));
						weather[i].setPrecipAccum(precipAccum);
						System.out.println(precipAccum);
					}
				}else if ((var.getName()).equalsIgnoreCase("precipAccumDD")){
					Array precipAccumDDArr = var.read();
					int rank= precipAccumDDArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = precipAccumDDArr.getShape();
					Index index = precipAccumDDArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
							char precipAccumDD = precipAccumDDArr.getChar(index.set(i));
							weather[i].setPrecipAccumDD(precipAccumDD);
						System.out.println(precipAccumDD);
					}
				}else if((var.getName()).equalsIgnoreCase("precipAccumQCA")){
					Array precipAccumQCAArr = var.read();
					int rank= precipAccumQCAArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = precipAccumQCAArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = precipAccumQCAArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int precipAccumQCA = precipAccumQCAArr.getInt(index.set(i));
						weather[i].setPrecipAccumQCA(precipAccumQCA);
						System.out.println(precipAccumQCA);
					}
				}else if((var.getName()).equalsIgnoreCase("precipAccumQCR")){
					Array precipAccumQCRArr = var.read();
					int rank= precipAccumQCRArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = precipAccumQCRArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = precipAccumQCRArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int precipAccumQCR = precipAccumQCRArr.getInt(index.set(i));
						weather[i].setPrecipAccumQCR(precipAccumQCR);
						System.out.println(precipAccumQCR);
					}
				}else if((var.getName()).equalsIgnoreCase("precipAccumQCD")){
					Array precipAccumQCDArr = var.read();
					int rank= precipAccumQCDArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = precipAccumQCDArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = precipAccumQCDArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float precipAccumQCD = precipAccumQCDArr.getFloat(index.set(i));
						weather[i].setPrecipAccumQCD(precipAccumQCD);
						System.out.println(precipAccumQCD);
					}
				}else if((var.getName()).equalsIgnoreCase("precipAccumICA")){
					Array precipAccumICAArr = var.read();
					int rank= precipAccumICAArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = precipAccumICAArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = precipAccumICAArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int precipAccumICA = precipAccumICAArr.getInt(index.set(i));
						weather[i].setPrecipAccumICA(precipAccumICA);
						System.out.println(precipAccumICA);
					}
				}else if((var.getName()).equalsIgnoreCase("precipAccumICR")){
					Array precipAccumICRArr = var.read();
					int rank= precipAccumICRArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = precipAccumICRArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = precipAccumICRArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int precipAccumICR = precipAccumICRArr.getInt(index.set(i));
						weather[i].setPrecipAccumICR(precipAccumICR);
						System.out.println(precipAccumICR);
					}
				}else if((var.getName()).equalsIgnoreCase("precipRate")){
					Array precipRateArr = var.read();
					int rank= precipRateArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = precipRateArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = precipRateArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float precipRate = precipRateArr.getFloat(index.set(i));
						weather[i].setPrecipRate(precipRate);
						System.out.println(precipRate);
					}
				}else if ((var.getName()).equalsIgnoreCase("precipRateDD")){
					Array precipRateDDArr = var.read();
					int rank= precipRateDDArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = precipRateDDArr.getShape();
					Index index = precipRateDDArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
							char precipRateDD = precipRateDDArr.getChar(index.set(i));
							weather[i].setPrecipRateDD(precipRateDD);
						System.out.println(precipRateDD);
					}
				}else if((var.getName()).equalsIgnoreCase("precipRateQCA")){
					Array precipRateQCAArr = var.read();
					int rank= precipRateQCAArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = precipRateQCAArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = precipRateQCAArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int precipRateQCA = precipRateQCAArr.getInt(index.set(i));
						weather[i].setPrecipRateQCA(precipRateQCA);
						System.out.println(precipRateQCA);
					}
				}else if((var.getName()).equalsIgnoreCase("precipRateQCR")){
					Array precipRateQCRArr = var.read();
					int rank= precipRateQCRArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = precipRateQCRArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = precipRateQCRArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int precipRateQCR = precipRateQCRArr.getInt(index.set(i));
						weather[i].setPrecipRateQCR(precipRateQCR);
						System.out.println(precipRateQCR);
					}
				}else if((var.getName()).equalsIgnoreCase("precipRateQCD")){
					Array precipRateQCDArr = var.read();
					int rank= precipRateQCDArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = precipRateQCDArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = precipRateQCDArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float precipRateQCD = precipRateQCDArr.getFloat(index.set(i));
						weather[i].setPrecipRateQCD(precipRateQCD);
						System.out.println(precipRateQCD);
					}
				}else if((var.getName()).equalsIgnoreCase("precipType")){
					Array precipTypeArr = var.read();
					int rank= precipTypeArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = precipTypeArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = precipTypeArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						short precipType = precipTypeArr.getShort(index.set(i));
						weather[i].setPrecipType(precipType);
						System.out.println(precipType);
					}
				}else if((var.getName()).equalsIgnoreCase("precipIntensity")){
					Array precipIntensityArr = var.read();
					int rank= precipIntensityArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = precipIntensityArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = precipIntensityArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						short precipIntensity = precipIntensityArr.getShort(index.set(i));
						weather[i].setPrecipIntensity(precipIntensity);
						System.out.println(precipIntensity);
					}
				}else if((var.getName()).equalsIgnoreCase("timeSinceLastPcp")){
					Array timeSinceLastPcpArr = var.read();
					int rank= timeSinceLastPcpArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = timeSinceLastPcpArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = timeSinceLastPcpArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						double timeSinceLastPcp = timeSinceLastPcpArr.getDouble(index.set(i));
						weather[i].setTimeSinceLastPcp(timeSinceLastPcp);
						System.out.println(timeSinceLastPcp);
					}
				}else if((var.getName()).equalsIgnoreCase("solarRadiation")){
					Array solarRadiationArr = var.read();
					int rank= solarRadiationArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = solarRadiationArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = solarRadiationArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float solarRadiation = solarRadiationArr.getFloat(index.set(i));
						weather[i].setSolarRadiation(solarRadiation);
						System.out.println(solarRadiation);
					}
				}else if((var.getName()).equalsIgnoreCase("solarRadChangeTime")){
					Array solarRadChangeTimeArr = var.read();
					int rank= solarRadChangeTimeArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = solarRadChangeTimeArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = solarRadChangeTimeArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						short solarRadChangeTime = solarRadChangeTimeArr.getShort(index.set(i));
						weather[i].setSolarRadChangeTime(solarRadChangeTime);
						System.out.println(solarRadChangeTime);
					}
				}else if((var.getName()).equalsIgnoreCase("seaSurfaceTemp")){
					Array seaSurfaceTempArr = var.read();
					int rank= seaSurfaceTempArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = seaSurfaceTempArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = seaSurfaceTempArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float seaSurfaceTemp = seaSurfaceTempArr.getFloat(index.set(i));
						weather[i].setSeaSurfaceTemp(seaSurfaceTemp);
						System.out.println(seaSurfaceTemp);
					}
				}else if ((var.getName()).equalsIgnoreCase("seaSurfaceTempDD")){
					Array seaSurfaceTempDDArr = var.read();
					int rank= seaSurfaceTempDDArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = seaSurfaceTempDDArr.getShape();
					Index index = seaSurfaceTempDDArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
							char seaSurfaceTempDD = seaSurfaceTempDDArr.getChar(index.set(i));
							weather[i].setSeaSurfaceTempDD(seaSurfaceTempDD);
						System.out.println(seaSurfaceTempDD);
					}
				}else if((var.getName()).equalsIgnoreCase("seaSurfaceTempQCA")){
					Array seaSurfaceTempQCAArr = var.read();
					int rank= seaSurfaceTempQCAArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = seaSurfaceTempQCAArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = seaSurfaceTempQCAArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int seaSurfaceTempQCA = seaSurfaceTempQCAArr.getInt(index.set(i));
						weather[i].setSeaSurfaceTempQCA(seaSurfaceTempQCA);
						System.out.println(seaSurfaceTempQCA);
					}
				}else if((var.getName()).equalsIgnoreCase("seaSurfaceTempQCR")){
					Array seaSurfaceTempQCRArr = var.read();
					int rank= seaSurfaceTempQCRArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = seaSurfaceTempQCRArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = seaSurfaceTempQCRArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int seaSurfaceTempQCR = seaSurfaceTempQCRArr.getInt(index.set(i));
						weather[i].setSeaSurfaceTempQCR(seaSurfaceTempQCR);
						System.out.println(seaSurfaceTempQCR);
					}
				}else if((var.getName()).equalsIgnoreCase("seaSurfaceTempQCD")){
					Array seaSurfaceTempQCDArr = var.read();
					int rank= seaSurfaceTempQCDArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = seaSurfaceTempQCDArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = seaSurfaceTempQCDArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float seaSurfaceTempQCD = seaSurfaceTempQCDArr.getFloat(index.set(i));
						weather[i].setSeaSurfaceTempQCD(seaSurfaceTempQCD);
						System.out.println(seaSurfaceTempQCD);
					}
				}else if((var.getName()).equalsIgnoreCase("seaSurfaceTempICA")){
					Array seaSurfaceTempICAArr = var.read();
					int rank= seaSurfaceTempICAArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = seaSurfaceTempICAArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = seaSurfaceTempICAArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int seaSurfaceTempICA = seaSurfaceTempICAArr.getInt(index.set(i));
						weather[i].setSeaSurfaceTempICA(seaSurfaceTempICA);
						System.out.println(seaSurfaceTempICA);
					}
				}else if((var.getName()).equalsIgnoreCase("seaSurfaceTempICR")){
					Array seaSurfaceTempICRArr = var.read();
					int rank= seaSurfaceTempICRArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = seaSurfaceTempICRArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = seaSurfaceTempICRArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int seaSurfaceTempICR = seaSurfaceTempICRArr.getInt(index.set(i));
						weather[i].setSeaSurfaceTempICR(seaSurfaceTempICR);
						System.out.println(seaSurfaceTempICR);
					}
				}else if ((var.getName()).equalsIgnoreCase("rawMessage")){
					String rawMessageString = "";
					Array rawMessageArr = var.read();
					int rank= rawMessageArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = rawMessageArr.getShape();
					Index index = rawMessageArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						for ( j=0; j<shape[1]; j++) {
							char dval = rawMessageArr.getChar(index.set(i,j));
							rawMessageString += dval;
							//System.out.print(dval);
						}
						System.out.println(rawMessageString);
						rawMessageString = rawMessageString.replaceAll("\\u0000", "" ) ;  
						//weather[i].setRawMessage(rawMessageString);
						rawMessageString = "";
					}
				}else if((var.getName()).equalsIgnoreCase("totalColumnPMV")){
					Array totalColumnPMVArr = var.read();
					int rank= totalColumnPMVArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = totalColumnPMVArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = totalColumnPMVArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float totalColumnPMV = totalColumnPMVArr.getFloat(index.set(i));
						weather[i].setTotalColumnPMV(totalColumnPMV);
						System.out.println(totalColumnPMV);
					}
				}else if((var.getName()).equalsIgnoreCase("totalSignalDelay")){
					Array totalSignalDelayArr = var.read();
					int rank= totalSignalDelayArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = totalSignalDelayArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = totalSignalDelayArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float totalSignalDelay = totalSignalDelayArr.getFloat(index.set(i));
						weather[i].setTotalSignalDelay(totalSignalDelay);
						System.out.println(totalSignalDelay);
					}
				}else if((var.getName()).equalsIgnoreCase("drySignalDelay")){
					Array drySignalDelayArr = var.read();
					int rank= drySignalDelayArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = drySignalDelayArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = drySignalDelayArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float drySignalDelay = drySignalDelayArr.getFloat(index.set(i));
						weather[i].setDrySignalDelay(drySignalDelay);
						System.out.println(drySignalDelay);
					}
				}else if((var.getName()).equalsIgnoreCase("wetSignalDelay")){
					Array wetSignalDelayArr = var.read();
					int rank= wetSignalDelayArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = wetSignalDelayArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = wetSignalDelayArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float wetSignalDelay = wetSignalDelayArr.getFloat(index.set(i));
						weather[i].setWetSignalDelay(wetSignalDelay);
						System.out.println(wetSignalDelay);
					}
				}else if((var.getName()).equalsIgnoreCase("meanWeightedTemperature")){
					Array meanWeightedTemperatureArr = var.read();
					int rank= meanWeightedTemperatureArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = meanWeightedTemperatureArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = meanWeightedTemperatureArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float meanWeightedTemperature = meanWeightedTemperatureArr.getFloat(index.set(i));
						weather[i].setMeanWeightedTemperature(meanWeightedTemperature);
						System.out.println(meanWeightedTemperature);
					}
				}else if((var.getName()).equalsIgnoreCase("formalError")){
					Array formalErrorArr = var.read();
					int rank= formalErrorArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = formalErrorArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = formalErrorArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float formalError = formalErrorArr.getFloat(index.set(i));
						weather[i].setFormalError(formalError);
						System.out.println(formalError);
					}
				}else if((var.getName()).equalsIgnoreCase("capPi")){
					Array capPiArr = var.read();
					int rank= capPiArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = capPiArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = capPiArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float capPi = capPiArr.getFloat(index.set(i));
						weather[i].setCapPi(capPi);
						System.out.println(capPi);
					}
				}else if((var.getName()).equalsIgnoreCase("roadTemperature1")){
					Array roadTemperature1Arr = var.read();
					int rank= roadTemperature1Arr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = roadTemperature1Arr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = roadTemperature1Arr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float roadTemperature1 = roadTemperature1Arr.getFloat(index.set(i));
						weather[i].setRoadTemperature1(roadTemperature1);
						System.out.println(roadTemperature1);
					}
				}else if((var.getName()).equalsIgnoreCase("roadTemperature2")){
					Array roadTemperature2Arr = var.read();
					int rank= roadTemperature2Arr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = roadTemperature2Arr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = roadTemperature2Arr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float roadTemperature2 = roadTemperature2Arr.getFloat(index.set(i));
						weather[i].setRoadTemperature2(roadTemperature2);
						System.out.println(roadTemperature2);
					}
				}else if((var.getName()).equalsIgnoreCase("roadTemperature3")){
					Array roadTemperature3Arr = var.read();
					int rank= roadTemperature3Arr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = roadTemperature3Arr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = roadTemperature3Arr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float roadTemperature3 = roadTemperature3Arr.getFloat(index.set(i));
						weather[i].setRoadTemperature3(roadTemperature3);
						System.out.println(roadTemperature3);
					}
				}else if((var.getName()).equalsIgnoreCase("roadTemperature4")){
					Array roadTemperature4Arr = var.read();
					int rank= roadTemperature4Arr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = roadTemperature4Arr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = roadTemperature4Arr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float roadTemperature4 = roadTemperature4Arr.getFloat(index.set(i));
						weather[i].setRoadTemperature4(roadTemperature4);
						System.out.println(roadTemperature4);
					}
				}else if((var.getName()).equalsIgnoreCase("roadLiquidFreezeTemp1")){
					Array roadLiquidFreezeTemp1Arr = var.read();
					int rank= roadLiquidFreezeTemp1Arr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = roadLiquidFreezeTemp1Arr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = roadLiquidFreezeTemp1Arr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float roadLiquidFreezeTemp1 = roadLiquidFreezeTemp1Arr.getFloat(index.set(i));
						weather[i].setRoadLiquidFreezeTemp1(roadLiquidFreezeTemp1);
						System.out.println(roadLiquidFreezeTemp1);
					}
				}else if((var.getName()).equalsIgnoreCase("roadLiquidFreezeTemp2")){
					Array roadLiquidFreezeTemp2Arr = var.read();
					int rank= roadLiquidFreezeTemp2Arr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = roadLiquidFreezeTemp2Arr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = roadLiquidFreezeTemp2Arr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float roadLiquidFreezeTemp2 = roadLiquidFreezeTemp2Arr.getFloat(index.set(i));
						weather[i].setRoadLiquidFreezeTemp2(roadLiquidFreezeTemp2);
						System.out.println(roadLiquidFreezeTemp2);
					}
				}else if((var.getName()).equalsIgnoreCase("roadLiquidFreezeTemp3")){
					Array roadLiquidFreezeTemp3Arr = var.read();
					int rank= roadLiquidFreezeTemp3Arr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = roadLiquidFreezeTemp3Arr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = roadLiquidFreezeTemp3Arr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float roadLiquidFreezeTemp3 = roadLiquidFreezeTemp3Arr.getFloat(index.set(i));
						weather[i].setRoadLiquidFreezeTemp3(roadLiquidFreezeTemp3);
						System.out.println(roadLiquidFreezeTemp3);
					}
				}else if((var.getName()).equalsIgnoreCase("roadLiquidFreezeTemp4")){
					Array roadLiquidFreezeTemp4Arr = var.read();
					int rank= roadLiquidFreezeTemp4Arr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = roadLiquidFreezeTemp4Arr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = roadLiquidFreezeTemp4Arr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float roadLiquidFreezeTemp4 = roadLiquidFreezeTemp4Arr.getFloat(index.set(i));
						weather[i].setRoadLiquidFreezeTemp4(roadLiquidFreezeTemp4);
						System.out.println(roadLiquidFreezeTemp4);
					}
				}else if((var.getName()).equalsIgnoreCase("roadLiquidChemFactor1")){
					Array roadLiquidChemFactor1Arr = var.read();
					int rank= roadLiquidChemFactor1Arr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = roadLiquidChemFactor1Arr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = roadLiquidChemFactor1Arr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float roadLiquidChemFactor1 = roadLiquidChemFactor1Arr.getFloat(index.set(i));
						weather[i].setRoadLiquidChemFactor1(roadLiquidChemFactor1);
						System.out.println(roadLiquidChemFactor1);
					}
				}else if((var.getName()).equalsIgnoreCase("roadLiquidChemFactor2")){
					Array roadLiquidChemFactor2Arr = var.read();
					int rank= roadLiquidChemFactor2Arr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = roadLiquidChemFactor2Arr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = roadLiquidChemFactor2Arr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float roadLiquidChemFactor2 = roadLiquidChemFactor2Arr.getFloat(index.set(i));
						weather[i].setRoadLiquidChemFactor2(roadLiquidChemFactor2);
						System.out.println(roadLiquidChemFactor2);
					}
				}else if((var.getName()).equalsIgnoreCase("roadLiquidChemFactor3")){
					Array roadLiquidChemFactor3Arr = var.read();
					int rank= roadLiquidChemFactor3Arr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = roadLiquidChemFactor3Arr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = roadLiquidChemFactor3Arr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float roadLiquidChemFactor3 = roadLiquidChemFactor3Arr.getFloat(index.set(i));
						weather[i].setRoadLiquidChemFactor3(roadLiquidChemFactor3);
						System.out.println(roadLiquidChemFactor3);
					}
				}else if((var.getName()).equalsIgnoreCase("roadLiquidChemFactor4")){
					Array roadLiquidChemFactor4Arr = var.read();
					int rank= roadLiquidChemFactor4Arr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = roadLiquidChemFactor4Arr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = roadLiquidChemFactor4Arr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float roadLiquidChemFactor4 = roadLiquidChemFactor4Arr.getFloat(index.set(i));
						weather[i].setRoadLiquidChemFactor4(roadLiquidChemFactor4);
						System.out.println(roadLiquidChemFactor4);
					}
				}else if((var.getName()).equalsIgnoreCase("roadLiquidChemPercent1")){
					Array roadLiquidChemPercent1Arr = var.read();
					int rank= roadLiquidChemPercent1Arr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = roadLiquidChemPercent1Arr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = roadLiquidChemPercent1Arr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float roadLiquidChemPercent1 = roadLiquidChemPercent1Arr.getFloat(index.set(i));
						weather[i].setRoadLiquidChemPercent1(roadLiquidChemPercent1);
						System.out.println(roadLiquidChemPercent1);
					}
				}else if((var.getName()).equalsIgnoreCase("roadLiquidChemPercent2")){
					Array roadLiquidChemPercent2Arr = var.read();
					int rank= roadLiquidChemPercent2Arr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = roadLiquidChemPercent2Arr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = roadLiquidChemPercent2Arr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float roadLiquidChemPercent2 = roadLiquidChemPercent2Arr.getFloat(index.set(i));
						System.out.println(roadLiquidChemPercent2);
					}
				}else if((var.getName()).equalsIgnoreCase("roadLiquidChemPercent3")){
					Array roadLiquidChemPercent3Arr = var.read();
					int rank= roadLiquidChemPercent3Arr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = roadLiquidChemPercent3Arr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = roadLiquidChemPercent3Arr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float roadLiquidChemPercent3 = roadLiquidChemPercent3Arr.getFloat(index.set(i));
						weather[i].setRoadLiquidChemPercent3(roadLiquidChemPercent3);
						System.out.println(roadLiquidChemPercent3);
					}
				}else if((var.getName()).equalsIgnoreCase("roadLiquidChemPercent4")){
					Array roadLiquidChemPercent4Arr = var.read();
					int rank= roadLiquidChemPercent4Arr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = roadLiquidChemPercent4Arr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = roadLiquidChemPercent4Arr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float roadLiquidChemPercent4 = roadLiquidChemPercent4Arr.getFloat(index.set(i));
						weather[i].setRoadLiquidChemPercent4(roadLiquidChemPercent4);
						System.out.println(roadLiquidChemPercent4);
					}
				}else if((var.getName()).equalsIgnoreCase("roadLiquidIcePercent1")){
					Array roadLiquidIcePercent1Arr = var.read();
					int rank= roadLiquidIcePercent1Arr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = roadLiquidIcePercent1Arr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = roadLiquidIcePercent1Arr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float roadLiquidIcePercent1 = roadLiquidIcePercent1Arr.getFloat(index.set(i));
						weather[i].setRoadLiquidIcePercent1(roadLiquidIcePercent1);
						System.out.println(roadLiquidIcePercent1);
					}
				}else if((var.getName()).equalsIgnoreCase("roadLiquidIcePercent2")){
					Array roadLiquidIcePercent2Arr = var.read();
					int rank= roadLiquidIcePercent2Arr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = roadLiquidIcePercent2Arr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = roadLiquidIcePercent2Arr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float roadLiquidIcePercent2 = roadLiquidIcePercent2Arr.getFloat(index.set(i));
						weather[i].setRoadLiquidIcePercent2(roadLiquidIcePercent2);
						System.out.println(roadLiquidIcePercent2);
					}
				}else if((var.getName()).equalsIgnoreCase("roadLiquidIcePercent3")){
					Array roadLiquidIcePercent3Arr = var.read();
					int rank= roadLiquidIcePercent3Arr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = roadLiquidIcePercent3Arr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = roadLiquidIcePercent3Arr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float roadLiquidIcePercent3 = roadLiquidIcePercent3Arr.getFloat(index.set(i));
						weather[i].setRoadLiquidIcePercent3(roadLiquidIcePercent3);
						System.out.println(roadLiquidIcePercent3);
					}
				}else if((var.getName()).equalsIgnoreCase("roadLiquidIcePercent4")){
					Array roadLiquidIcePercent4Arr = var.read();
					int rank= roadLiquidIcePercent4Arr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = roadLiquidIcePercent4Arr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = roadLiquidIcePercent4Arr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float roadLiquidIcePercent4 = roadLiquidIcePercent4Arr.getFloat(index.set(i));
						weather[i].setRoadLiquidIcePercent4(roadLiquidIcePercent4);
						System.out.println(roadLiquidIcePercent4);
					}
				}else if((var.getName()).equalsIgnoreCase("roadLiquidDepth1")){
					Array roadLiquidDepth1Arr = var.read();
					int rank= roadLiquidDepth1Arr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = roadLiquidDepth1Arr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = roadLiquidDepth1Arr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float roadLiquidDepth1 = roadLiquidDepth1Arr.getFloat(index.set(i));
						weather[i].setRoadLiquidDepth1(roadLiquidDepth1);
						System.out.println(roadLiquidDepth1);
					}
				}else if((var.getName()).equalsIgnoreCase("roadLiquidDepth2")){
					Array roadLiquidDepth2Arr = var.read();
					int rank= roadLiquidDepth2Arr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = roadLiquidDepth2Arr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = roadLiquidDepth2Arr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float roadLiquidDepth2 = roadLiquidDepth2Arr.getFloat(index.set(i));
						weather[i].setRoadLiquidDepth2(roadLiquidDepth2);
						System.out.println(roadLiquidDepth2);
					}
				}else if((var.getName()).equalsIgnoreCase("roadLiquidDepth3")){
					Array roadLiquidDepth3Arr = var.read();
					int rank= roadLiquidDepth3Arr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = roadLiquidDepth3Arr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = roadLiquidDepth3Arr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float roadLiquidDepth3 = roadLiquidDepth3Arr.getFloat(index.set(i));
						weather[i].setRoadLiquidDepth3(roadLiquidDepth3);
						System.out.println(roadLiquidDepth3);
					}
				}else if((var.getName()).equalsIgnoreCase("roadLiquidDepth4")){
					Array roadLiquidDepth4Arr = var.read();
					int rank= roadLiquidDepth4Arr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = roadLiquidDepth4Arr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = roadLiquidDepth4Arr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float roadLiquidDepth4 = roadLiquidDepth4Arr.getFloat(index.set(i));
						weather[i].setRoadLiquidDepth4(roadLiquidDepth4);
						System.out.println(roadLiquidDepth4);
					}
				}else if((var.getName()).equalsIgnoreCase("roadState1")){
					Array roadState1Arr = var.read();
					int rank= roadState1Arr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = roadState1Arr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = roadState1Arr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						short roadState1 = roadState1Arr.getShort(index.set(i));
						weather[i].setRoadState1(roadState1);
						System.out.println(roadState1);
					}
				}else if((var.getName()).equalsIgnoreCase("roadState2")){
					Array roadState2Arr = var.read();
					int rank= roadState2Arr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = roadState2Arr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = roadState2Arr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						short roadState2 = roadState2Arr.getShort(index.set(i));
						weather[i].setRoadState2(roadState2);
						System.out.println(roadState2);
					}
				}else if((var.getName()).equalsIgnoreCase("roadState3")){
					Array roadState3Arr = var.read();
					int rank= roadState3Arr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = roadState3Arr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = roadState3Arr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						short roadState3 = roadState3Arr.getShort(index.set(i));
						weather[i].setRoadState3(roadState3);
						System.out.println(roadState3);
					}
				}else if((var.getName()).equalsIgnoreCase("roadState4")){
					Array roadState4Arr = var.read();
					int rank= roadState4Arr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = roadState4Arr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = roadState4Arr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						short roadState4 = roadState4Arr.getShort(index.set(i));
						weather[i].setRoadState4(roadState4);
						System.out.println(roadState4);
					}
				}else if((var.getName()).equalsIgnoreCase("roadSubSurfaceTemp1")){
					Array roadSubSurfaceTemp1Arr = var.read();
					int rank= roadSubSurfaceTemp1Arr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = roadSubSurfaceTemp1Arr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = roadSubSurfaceTemp1Arr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float roadSubSurfaceTemp1 = roadSubSurfaceTemp1Arr.getFloat(index.set(i));
						weather[i].setRoadSubSurfaceTemp1(roadSubSurfaceTemp1);
						System.out.println(roadSubSurfaceTemp1);
					}
				}else if((var.getName()).equalsIgnoreCase("roadSubSurfaceTemp2")){
					Array roadSubSurfaceTemp2Arr = var.read();
					int rank= roadSubSurfaceTemp2Arr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = roadSubSurfaceTemp2Arr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = roadSubSurfaceTemp2Arr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float roadSubSurfaceTemp2 = roadSubSurfaceTemp2Arr.getFloat(index.set(i));
						weather[i].setRoadSubSurfaceTemp2(roadSubSurfaceTemp2);
						System.out.println(roadSubSurfaceTemp2);
					}
				}else if((var.getName()).equalsIgnoreCase("roadSubSurfaceTemp3")){
					Array roadSubSurfaceTemp3Arr = var.read();
					int rank= roadSubSurfaceTemp3Arr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = roadSubSurfaceTemp3Arr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = roadSubSurfaceTemp3Arr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float roadSubSurfaceTemp3 = roadSubSurfaceTemp3Arr.getFloat(index.set(i));
						weather[i].setRoadSubSurfaceTemp3(roadSubSurfaceTemp3);
						System.out.println(roadSubSurfaceTemp3);
					}
				}else if((var.getName()).equalsIgnoreCase("roadSubSurfaceTemp4")){
					Array roadSubSurfaceTemp4Arr = var.read();
					int rank= roadSubSurfaceTemp4Arr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = roadSubSurfaceTemp4Arr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = roadSubSurfaceTemp4Arr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float roadSubSurfaceTemp4 = roadSubSurfaceTemp4Arr.getFloat(index.set(i));
						weather[i].setRoadSubSurfaceTemp4(roadSubSurfaceTemp4);
						System.out.println(roadSubSurfaceTemp4);
					}
				}else if((var.getName()).equalsIgnoreCase("fuelTemperature")){
					Array fuelTemperatureArr = var.read();
					int rank= fuelTemperatureArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = fuelTemperatureArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = fuelTemperatureArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float fuelTemperature = fuelTemperatureArr.getFloat(index.set(i));
						weather[i].setFuelTemperature(fuelTemperature);
						System.out.println(fuelTemperature);
					}
				}else if((var.getName()).equalsIgnoreCase("fuelTempChangeTime")){
					Array fuelTempChangeTimeArr = var.read();
					int rank= fuelTempChangeTimeArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = fuelTempChangeTimeArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = fuelTempChangeTimeArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						double fuelTempChangeTime = fuelTempChangeTimeArr.getDouble(index.set(i));
						weather[i].setFuelTempChangeTime(fuelTempChangeTime);
						System.out.println(fuelTempChangeTime);
					}
				}else if((var.getName()).equalsIgnoreCase("fuelMoisture")){
					Array fuelMoistureArr = var.read();
					int rank= fuelMoistureArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = fuelMoistureArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = fuelMoistureArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float fuelMoisture = fuelMoistureArr.getFloat(index.set(i));
						weather[i].setFuelMoisture(fuelMoisture);
						System.out.println(fuelMoisture);
					}
				}else if((var.getName()).equalsIgnoreCase("fuelMoistChangeTime")){
					Array fuelMoistChangeTimeArr = var.read();
					int rank= fuelMoistChangeTimeArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = fuelMoistChangeTimeArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = fuelMoistChangeTimeArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						double fuelMoistChangeTime = fuelMoistChangeTimeArr.getDouble(index.set(i));
						weather[i].setFuelMoistChangeTime(fuelMoistChangeTime);
						System.out.println(fuelMoistChangeTime);
					}
				}else if((var.getName()).equalsIgnoreCase("soilTemperature")){
					Array soilTemperatureArr = var.read();
					int rank= soilTemperatureArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = soilTemperatureArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = soilTemperatureArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float soilTemperature = soilTemperatureArr.getFloat(index.set(i));
						weather[i].setSoilTemperature(soilTemperature);
						System.out.println(soilTemperature);
					}
				}else if ((var.getName()).equalsIgnoreCase("soilTemperatureDD")){
					Array soilTemperatureDDArr = var.read();
					int rank= soilTemperatureDDArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = soilTemperatureDDArr.getShape();
					Index index = soilTemperatureDDArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
							char soilTemperatureDD = soilTemperatureDDArr.getChar(index.set(i));
							weather[i].setSoilTemperatureDD(soilTemperatureDD);
						System.out.println(soilTemperatureDD);
					}
				}else if((var.getName()).equalsIgnoreCase("soilTemperatureQCA")){
					Array soilTemperatureQCAArr = var.read();
					int rank= soilTemperatureQCAArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = soilTemperatureQCAArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = soilTemperatureQCAArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int soilTemperatureQCA = soilTemperatureQCAArr.getInt(index.set(i));
						weather[i].setSoilTemperatureQCA(soilTemperatureQCA);
						System.out.println(soilTemperatureQCA);
					}
				}else if((var.getName()).equalsIgnoreCase("soilTemperatureQCR")){
					Array soilTemperatureQCRArr = var.read();
					int rank= soilTemperatureQCRArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = soilTemperatureQCRArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = soilTemperatureQCRArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int soilTemperatureQCR = soilTemperatureQCRArr.getInt(index.set(i));
						weather[i].setSoilTemperatureQCR(soilTemperatureQCR);
						System.out.println(soilTemperatureQCR);
					}
				}else if((var.getName()).equalsIgnoreCase("soilTemperatureQCD")){
					Array soilTemperatureQCDArr = var.read();
					int rank= soilTemperatureQCDArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = soilTemperatureQCDArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = soilTemperatureQCDArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float soilTemperatureQCD = soilTemperatureQCDArr.getFloat(index.set(i));
						weather[i].setSoilTemperatureQCD(soilTemperatureQCD);
						System.out.println(soilTemperatureQCD);
					}
				}else if((var.getName()).equalsIgnoreCase("soilMoisturePercent")){
					Array soilMoisturePercentArr = var.read();
					int rank= soilMoisturePercentArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = soilMoisturePercentArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = soilMoisturePercentArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float soilMoisturePercent = soilMoisturePercentArr.getFloat(index.set(i));
						weather[i].setSoilMoisturePercent(soilMoisturePercent);
						System.out.println(soilMoisturePercent);
					}
				}else if ((var.getName()).equalsIgnoreCase("soilMoisturePercentDD")){
					Array soilMoisturePercentDDArr = var.read();
					int rank= soilMoisturePercentDDArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = soilMoisturePercentDDArr.getShape();
					Index index = soilMoisturePercentDDArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
							char soilMoisturePercentDD = soilMoisturePercentDDArr.getChar(index.set(i));
							weather[i].setSoilMoisturePercentDD(soilMoisturePercentDD);
						System.out.println(soilMoisturePercentDD);
					}
				}else if((var.getName()).equalsIgnoreCase("soilMoisturePercentQCA")){
					Array soilMoisturePercentQCAArr = var.read();
					int rank= soilMoisturePercentQCAArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = soilMoisturePercentQCAArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = soilMoisturePercentQCAArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int soilMoisturePercentQCA = soilMoisturePercentQCAArr.getInt(index.set(i));
						weather[i].setSoilMoisturePercentQCA(soilMoisturePercentQCA);
						System.out.println(soilMoisturePercentQCA);
					}
				}else if((var.getName()).equalsIgnoreCase("soilMoisturePercentQCR")){
					Array soilMoisturePercentQCRArr = var.read();
					int rank= soilMoisturePercentQCRArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = soilMoisturePercentQCRArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = soilMoisturePercentQCRArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						int soilMoisturePercentQCR = soilMoisturePercentQCRArr.getInt(index.set(i));
						weather[i].setSoilMoisturePercentQCR(soilMoisturePercentQCR);
						System.out.println(soilMoisturePercentQCR);
					}
				}else if((var.getName()).equalsIgnoreCase("soilMoisturePercentQCD")){
					Array soilMoisturePercentQCDArr = var.read();
					int rank= soilMoisturePercentQCDArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = soilMoisturePercentQCDArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = soilMoisturePercentQCDArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float soilMoisturePercentQCD = soilMoisturePercentQCDArr.getFloat(index.set(i));
						weather[i].setSoilMoisturePercentQCD(soilMoisturePercentQCD);
						System.out.println(soilMoisturePercentQCD);
					}
				}else if((var.getName()).equalsIgnoreCase("soilMoisturePercentQCD")){
					Array soilMoisturePercentQCDArr = var.read();
					int rank= soilMoisturePercentQCDArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = soilMoisturePercentQCDArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = soilMoisturePercentQCDArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float soilMoisturePercentQCD = soilMoisturePercentQCDArr.getFloat(index.set(i));
						weather[i].setSoilMoisturePercentQCD(soilMoisturePercentQCD);
						System.out.println(soilMoisturePercentQCD);
					}
				}else if((var.getName()).equalsIgnoreCase("waterLevel")){
					Array waterLevelArr = var.read();
					int rank= waterLevelArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = waterLevelArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = waterLevelArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float waterLevel = waterLevelArr.getFloat(index.set(i));
						weather[i].setWaterLevel(waterLevel);
						System.out.println(waterLevel);
					}
				}else if((var.getName()).equalsIgnoreCase("mobileLat")){
					Array mobileLatArr = var.read();
					int rank= mobileLatArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = mobileLatArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = mobileLatArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float mobileLat = mobileLatArr.getFloat(index.set(i));
						weather[i].setMobileLat(mobileLat);
						System.out.println(mobileLat);
					}
				}else if((var.getName()).equalsIgnoreCase("mobileLon")){
					Array mobileLonArr = var.read();
					int rank= mobileLonArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = mobileLonArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = mobileLonArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float mobileLon = mobileLonArr.getFloat(index.set(i));
						weather[i].setMobileLon(mobileLon);
						System.out.println(mobileLon);
					}
				}else if((var.getName()).equalsIgnoreCase("mobileElev")){
					Array mobileElevArr = var.read();
					int rank= mobileElevArr.getRank();
					System.out.println("Rank is: "+rank);
					int[] shape = mobileElevArr.getShape();
					System.out.println("Shape[0]: "+shape[0]);
					Index index = mobileElevArr.getIndex();
					for ( i=0; i<shape[0]; i++) {
						float mobileElev = mobileElevArr.getFloat(index.set(i));
						weather[i].setMobileElev(mobileElev);
						System.out.println(mobileElev);
					}
				}
				
				java.util.List<Attribute> attrList = var.getAttributes();
				Iterator<Attribute> attrIterator = attrList.iterator();
				while (attrIterator.hasNext()){
					System.out.println("Attribute type:"+attrIterator.next().getDataType());     		
				}
			}
			
			//Inserting data into the Database
			
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			// this would save the weather object into the database
			for (i=0 ; i<90244; i++){
				session.save(weather[i]);				
			}
			session.getTransaction().commit();
			session.close();
			sessionFactory.close();

			// System.out.println(attr.getValue(0));
			/*
	    String varName = "stationIdVariable"; 
	    Variable v = ncfile.findVariable(varName);
	     if (null == v) return;
	    try {
	    	java.util.List<Variable> variableList = ncfile.getVariables();
	    	Iterator<Variable> iterator = variableList.iterator();
	    	while (iterator.hasNext()) {
	    		System.out.println(iterator.next().getDescription());
	    	}
	    Array data = v.read("0:2:1, 0:19:1");
	     NCdumpW.printArray(data, varName,
	     System.out, null);
	    } catch (IOException ioe) {
	    log("trying to read " + varName, ioe);

	     } catch (InvalidRangeException e) {
	       log("invalid Range for " + varName, e);
	     }
			 */
		} catch (IOException ioe) {
			System.out.println("trying to open " + filename + ioe);
		} finally { 
			if (null != ncfile) try {
				ncfile.close();
			} catch (IOException ioe) {
				System.out.println("trying to close " + filename + ioe);
			}
		}

	}
}

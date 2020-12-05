import entity.Airport;
import entity.plane.ExperimentalPlane;
import entity.type.ClassificationLevel;
import entity.type.ExperimentalPlaneType;
import entity.type.MilitaryPlaneType;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import entity.plane.MilitaryPlane;
import entity.plane.PassengerPlane;
import entity.plane.Plane;

import java.util.Arrays;
import java.util.List;

public class AirportTest {
    private static Airport airportToTest;

    @BeforeTest
    private void createAirport() {
        List<Plane> planesList = Arrays.asList(
                new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
                new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
                new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
                new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
                new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
                new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
                new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
                new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
                new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryPlaneType.BOMBER),
                new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryPlaneType.BOMBER),
                new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryPlaneType.BOMBER),
                new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryPlaneType.FIGHTER),
                new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryPlaneType.FIGHTER),
                new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryPlaneType.TRANSPORT),
                new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalPlaneType.HIGH_ALTITUDE, ClassificationLevel.SECRET),
                new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalPlaneType.VTOL, ClassificationLevel.TOP_SECRET));

                airportToTest = new Airport(planesList);
    }

    @Test
    public void hasAtLeastOneTransportInMilitaryPlanesTest() {
        Assert.assertTrue(airportToTest.getTransportMilitaryPlanes().stream()
                .anyMatch(militaryPlane -> militaryPlane.getType() == MilitaryPlaneType.TRANSPORT));
    }

    @Test
    public void getPassengerPlaneWithMaxPassengerCapacityTest() {
        Assert.assertEquals(new PassengerPlane("Boeing-747", 980, 16100,
                70500, 242), airportToTest.getPassengerPlaneWithMaxPassengersCapacity());
    }

    @Test
    public void hasAtLeastOneBomberInMilitaryPlanesTest() {
        Assert.assertTrue(airportToTest.getBomberMilitaryPlanes().stream()
                .anyMatch(militaryPlane -> militaryPlane.getType() == MilitaryPlaneType.BOMBER));
    }

    @Test
    public void experimentalPlanesHasClassificationLevelHigherThanUnclassifiedTest() {
        Assert.assertFalse(airportToTest.getExperimentalPlanes().stream()
                .anyMatch(experimentalPlane -> experimentalPlane.getClassificationLevel() == ClassificationLevel.UNCLASSIFIED));
    }

    @DataProvider()
    public Object[][] allPlanesProvider() {
        return new Object[][]{{
                Arrays.asList(
                        new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
                        new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
                        new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
                        new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
                        new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
                        new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
                        new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
                        new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
                        new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryPlaneType.BOMBER),
                        new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryPlaneType.BOMBER),
                        new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryPlaneType.BOMBER),
                        new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryPlaneType.FIGHTER),
                        new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryPlaneType.FIGHTER),
                        new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryPlaneType.TRANSPORT),
                        new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalPlaneType.HIGH_ALTITUDE, ClassificationLevel.SECRET),
                        new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalPlaneType.VTOL, ClassificationLevel.TOP_SECRET)
                )
        }
        };
    }

    @Test(dataProvider = "allPlanesProvider")
    public void getAllPlanesTest(List<? extends Plane> expected) {
        Assert.assertEquals(expected, airportToTest.getAllPlanes());
    }

    @DataProvider()
    public Object[][] getPassengerPlanesProvider() {
        return new Object[][]{{
                Arrays.asList(
                        new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
                        new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
                        new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
                        new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
                        new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
                        new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
                        new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
                        new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196)
                )
        }
        };
    }

    @Test(dataProvider = "getPassengerPlanesProvider")
    public void getPassengerPlanesTest(List<PassengerPlane> expected) {
        Assert.assertEquals(expected, airportToTest.getPassengerPlanes());
    }

    @DataProvider()
    public Object[][] getExperimentalPlanesProvider() {
        return new Object[][]{{
                Arrays.asList(
                        new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalPlaneType.HIGH_ALTITUDE, ClassificationLevel.SECRET),
                        new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalPlaneType.VTOL, ClassificationLevel.TOP_SECRET)
                )
        }
        };
    }

    @Test(dataProvider = "getExperimentalPlanesProvider")
    public void getExperimentalPlanesTest(List<ExperimentalPlane> expected){
        Assert.assertEquals(expected, airportToTest.getExperimentalPlanes());
    }

    @DataProvider()
    public Object[][] getMilitaryPlanesProvider() {
        return new Object[][]{{
                Arrays.asList(
                        new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryPlaneType.BOMBER),
                        new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryPlaneType.BOMBER),
                        new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryPlaneType.BOMBER),
                        new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryPlaneType.FIGHTER),
                        new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryPlaneType.FIGHTER),
                        new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryPlaneType.TRANSPORT)
                )
        }
        };
    }

    @Test(dataProvider = "getMilitaryPlanesProvider")
    public void getMilitaryPlanesTest(List<ExperimentalPlane> expected){
        Assert.assertEquals(expected, airportToTest.getMilitaryPlanes());
    }

    @DataProvider()
    public Object[][] getTransportMilitaryPlanesProvider() {
        return new Object[][]{{
                Arrays.asList(
                        new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryPlaneType.TRANSPORT)
                )
        }
        };
    }


    @Test(dataProvider = "getTransportMilitaryPlanesProvider")
    public void getTransportMilitaryPlanesTest(List<MilitaryPlane> expected) {
        Assert.assertEquals(expected, airportToTest.getTransportMilitaryPlanes());
    }

    @DataProvider()
    public Object[][] getBomberMilitaryPlanesProvider() {
        return new Object[][]{{
                Arrays.asList(
                        new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryPlaneType.BOMBER),
                        new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryPlaneType.BOMBER),
                        new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryPlaneType.BOMBER)
                )
        }
        };
    }

    @Test(dataProvider = "getBomberMilitaryPlanesProvider")
    public void getBomberMilitaryPlanesTest(List<MilitaryPlane> expected) {
        Assert.assertEquals(expected, airportToTest.getBomberMilitaryPlanes());
    }

    @DataProvider()
    public Object[][] getFighterMilitaryPlanesProvider() {
        return new Object[][] { {
                Arrays.asList(
                        new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryPlaneType.FIGHTER),
                        new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryPlaneType.FIGHTER)
                )
        }
        };
    }

    @Test(dataProvider = "getFighterMilitaryPlanesProvider")
    public void getFighterMilitaryPlanesTest(List<MilitaryPlane> expected) {
        Assert.assertEquals(expected, airportToTest.getFighterMilitaryPlanes());
    }

    @DataProvider()
    public Object[][] getSortedByMaxSpeedPlanes(){
        return new Object[][]{{
                Arrays.asList(
                        new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalPlaneType.HIGH_ALTITUDE, ClassificationLevel.SECRET),
                        new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalPlaneType.VTOL, ClassificationLevel.TOP_SECRET),
                        new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryPlaneType.TRANSPORT),
                        new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
                        new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
                        new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
                        new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
                        new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
                        new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
                        new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
                        new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
                        new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryPlaneType.BOMBER),
                        new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryPlaneType.BOMBER),
                        new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryPlaneType.BOMBER),
                        new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryPlaneType.FIGHTER),
                        new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryPlaneType.FIGHTER)
                )
        }
        };
    }

    @Test(dataProvider = "getSortedByMaxSpeedPlanes")
    public void sortByMaxSpeedTest(List<Plane> expected){
        airportToTest.sortByMaxSpeed();
        Assert.assertEquals(expected, airportToTest.getAllPlanes());
    }

    @DataProvider()
    public Object[][] getSortedByMaxFlightDistancePlanes(){
        return new Object[][]{{
                Arrays.asList(
                        new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalPlaneType.VTOL, ClassificationLevel.TOP_SECRET),
                        new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalPlaneType.HIGH_ALTITUDE, ClassificationLevel.SECRET),
                        new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryPlaneType.TRANSPORT),
                        new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
                        new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
                        new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
                        new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
                        new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryPlaneType.FIGHTER),
                        new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
                        new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
                        new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryPlaneType.FIGHTER),
                        new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
                        new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
                        new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryPlaneType.BOMBER),
                        new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryPlaneType.BOMBER),
                        new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryPlaneType.BOMBER)
                )
        }
        };
    }

    @Test(dataProvider = "getSortedByMaxFlightDistancePlanes")
    public void sortByMaxFlightDistanceTest(List<Plane> expected){
        airportToTest.sortByMaxDistance();
        Assert.assertEquals(expected, airportToTest.getAllPlanes());
    }

    @DataProvider()
    public Object[][] getSortedByMaxLoadCapacityPlanes(){
        return new Object[][]{{
                Arrays.asList(
                        new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalPlaneType.HIGH_ALTITUDE, ClassificationLevel.SECRET),
                        new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalPlaneType.VTOL, ClassificationLevel.TOP_SECRET),
                        new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryPlaneType.FIGHTER),
                        new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryPlaneType.FIGHTER),
                        new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
                        new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
                        new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
                        new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
                        new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
                        new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
                        new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryPlaneType.BOMBER),
                        new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
                        new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryPlaneType.BOMBER),
                        new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryPlaneType.BOMBER),
                        new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
                        new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryPlaneType.TRANSPORT)
                )
        }
        };
    }

    @Test(dataProvider = "getSortedByMaxLoadCapacityPlanes")
    public void sortByMaxByMaxLoadCapacityTest(List<Plane> expected){
        airportToTest.sortByMaxLoadCapacity();
        Assert.assertEquals(expected, airportToTest.getAllPlanes());
    }
}

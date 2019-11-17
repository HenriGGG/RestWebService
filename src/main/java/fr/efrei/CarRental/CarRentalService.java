package fr.efrei.CarRental;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;

@RestController
public class CarRentalService {
	
	private List<Car> cars = new ArrayList<Car>();
	private List<Rent> rents = new ArrayList<Rent>();
	
	public CarRentalService() {
		cars.add(new Car("11AA22", "Ferrari", 1000));
		cars.add(new Car("33BB44", "Porshe", 2222));
	}
	
	@RequestMapping(value="/cars", method=RequestMethod.GET) 
	@ResponseStatus(HttpStatus.OK) 
	public List<Car> getListOfCars(){
		return cars;
	}
	
	@RequestMapping(value = "/cars", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void addCar(@RequestBody Car car) throws Exception{
		System.out.println(car);
		cars.add(car);
	}
	
	@RequestMapping(value = "/cars", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Car> listOfCars(){
		return cars;
	}
	@RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Car aCar(@PathVariable("plateNumber") String plateNumber) throws Exception{
		for(Car car: cars){
			if(car.getPlateNumber().equals(plateNumber)){
				return car;
			}
		}
		return null;
	}

	@RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void getBack(@PathVariable("plateNumber") String plateNumber) throws Exception{
		for(Car car: cars){
			if(car.getPlateNumber().equals(plateNumber)){
				cars.remove(car);
			}
		}
		return;
	}

	@RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void rent(@PathVariable("plateNumber") String plateNumber) throws Exception{
			for(Car car: cars){
			if(car.getPlateNumber().equals(plateNumber)){
				car.setRent(true);
			}
		}
		return;
	}
	
	@RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK) 
	public void	rentAndGetBack(@PathVariable("plateNumber") String plateNumber,
	@RequestParam(value="rent", required = true)boolean rent) throws Exception{
		for(Car car: cars){
			if(car.getPlateNumber().equals(plateNumber)){
				car.setRent(rent);
				break;
			}
		}
		return;
		
	}
	
	@RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.PUT)
	public void rent(@PathVariable("plateNumber") String plateNumber, @RequestParam(value="rent",
	required = true)boolean rent, @RequestBody String dates){
		for(Car car: cars){
			if(car.getPlateNumber().equals(plateNumber)){
				car.setRent(rent);
			}
		}
		Rent rent1 = new Rent(plateNumber, dates, dates);
		System.out.println(rent1);
		rents.add(rent1);
	}
	


}

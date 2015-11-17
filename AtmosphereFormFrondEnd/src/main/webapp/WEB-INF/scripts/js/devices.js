function getManufacturers(scope, http) {
	http.get('/AtmosphereFormFrondEnd/manufacturers', {
		headers : {
			'Accept' : 'application/json'
		}
	}).success(function(data) {
		console.log("Hello manufacture!");
		scope.manufacturers = data.manufacturers;
	});
}

function getModels(scope, http, manufacturerId) {
	http.get(

			'/AtmosphereFormFrondEnd/models?' + 'filter="manufacturer.id::'
					+ manufacturerId + '"', {
				headers : {
					'Accept' : 'application/json'
				}
			}).success(function(data) {
		console.log("Hello models");
		scope.models = data.models;
	});
}

function getNumbers(scope, http, modelId) {
	http.get(
			'/AtmosphereFormFrondEnd/modelNumbers?' + 'filter="phoneModel.id::'
					+ modelId + '"', {
				headers : {
					'Accept' : 'application/json'
				}
			}).success(function(data) {
		console.log("Hello model numbers!");
		scope.numbers = data.numbers;
		console.log(data.numbers);
	});
}

function getAndroids(scope, http) {
	console.log("Hello");
	http.get('/AtmosphereFormFrondEnd/androids', {
		headers : {
			'Accept' : 'application/xml'
		}
	}).success(function(data) {
		console.log("Found THE ANDROIDS!");
		scope.androids = data.androids;
	});
}

    var timer;
	function filterModelNumbers(scope, http, filter) {
		if(timer != undefined) {
			clearTimeout(timer);
		}
		
		timer = setTimeout(function(){
		http.get(

				'/AtmosphereFormFrondEnd/modelNumbers/filter?' + 'filter="name::'
						+ filter + '"', {
					headers : {
						'Accept' : 'application/json'
					}
				}).success(function(data) {

			scope.numbers = data.numbers;
		})
		}, 1000);
	}

	function getModelNumbersForUser(scope, http) {
		http.get(
				'/AtmosphereFormFrondEnd/reports/modelNumbers?' + 'author='
						+ scope.report.author, {
					headers : {
						'Accept' : 'application/json'
					}
				}).success(function(data) {

			scope.usedNumbers = data.numbers;
			
			if (scope.numbers.length == 0) {
				scope.numbers = scope.usedNumbers;
			}
			if (scope.numbers.length == 1) {
				scope.device.number = scope.numbers[0];
				scope.fillDeviceCombos();
			}
		});
	}

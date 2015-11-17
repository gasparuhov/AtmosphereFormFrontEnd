app
		.controller(
				'reportController',
				function($scope, $http) {

					$scope.report = {};
					$scope.manufacturers = [];
					$scope.models = [];
					$scope.numbers = [];
					$scope.androids = [];
					$scope.usedNumbers = [];

					$scope.device = {};
					$scope.file = {};

					init($scope);
					getAndroids($scope, $http);
					getManufacturers($scope, $http);

					$scope.refreshModels = function() {

						console.log($scope.device.manufacturer);

						$scope.models = [];
						$scope.device.model = undefined;
						$scope.refreshNumbers();

						if ($scope.device.manufacturer == undefined) {
							return;
						}

						getModels($scope, $http, $scope.device.manufacturer.id);
					};

					$scope.refreshNumbers = function() {

						$scope.numbers = [];
						$scope.device.number = undefined;
						if ($scope.device.model == undefined) {
							return;
						}

						getNumbers($scope, $http, $scope.device.model.id);
					};

					$scope.filterNumbers = function(filter) {

						if ($scope.device.model != undefined
								|| $scope.device.manufacturer != undefined) {
							return;
						}

						if (filter == "") {
							return;
						}

						$scope.numbers = [];
						filterModelNumbers($scope, $http, filter);
					};

					$scope.fillDeviceCombos = function() {

						if ($scope.device.number != undefined) {
							if ($scope.device.model == undefined) {
								$scope.device.model = $scope.device.number.phoneModel;
							}

							if ($scope.device.manufacturer == undefined) {
								$scope.device.manufacturer = $scope.device.number.phoneModel.manufacturer;
							}
						}

					};
					

					$scope.getUsedNumbers = function() {
						getModelNumbersForUser($scope, $http);
					};
					$scope.submit = function() {

						var file = null;
						if ($scope.file != null && $scope.file.length == 1) {
							file = $scope.file[0];
						}

						$scope.report.android = $scope.device.android;
						$scope.report.phoneModelNumber = $scope.device.number;

						var formData = new FormData();
						formData.append("report", JSON.stringify($scope.report,
								ignoreHashKey));
						if (file != null) {
							formData.append("file", file);
						}

						
						$.ajax({
						    url: '/AtmosphereFormFrondEnd/report/save',
						    data: formData,
						    dataType: 'text',
						    processData: false,
						    contentType: false,
						    type: 'POST',
						    success: function(data){

						    	console.log(data);
						    }
						  }).success(
							function(data, status, headers, config) {
								angular.element($('#messages')).addClass(
										'alert alert-success').text(
										data.message);

							}).error(
							function(data, status, headers, config) {
								angular.element($('#messages')).addClass(
										'alert alert-danger').text(
										'There was error while submitting your report! Pleace try again!');
								console.log("\n data: " + data);
							});
						
//						$http.post(
//						// 'http://localhost:8080/Atmosphere/reports'
//						'/AtmosphereFormFrondEnd/report/save', formData, {
//							headers : {
////								'Content-Type': 'application/json',
//////									'multipart/form-data;boundary=gc0p4Jq0M2Yt08jU534c0p',
////								'Accept' : 'application/json'
//									
//									'dataType': 'text',
//								    'processData': false,
//								    'contentType': false,


						clearForm();
						window.scrollTo(0, 0);
					};

					function ignoreHashKey(key, value) {
						if (key == "$$hashKey")
							return undefined;
						else
							return value;
					}

					function clearForm() {
						$scope.models = [];
						$scope.numbers = [];

						$scope.device.manufacturer = undefined;
						$scope.device.model = undefined;
						$scope.device.number = undefined;
						$scope.device.android = undefined;

						$scope.report.description = "";
						$scope.report.application = "";
						$scope.report.appVersion = "";
						$scope.report.appURL = "";
						$scope.report.android = {};
						$scope.report.phoneModelNumber = {};
						$scope.report.stepsToReproduce = "";
						$scope.report.actualResult = "";
						$scope.report.expectedResult = "";
						$scope.report.author = "";
						$scope.reportForm.$setPristine()

						$("#fileInput").fileinput('reset');
					}

				});

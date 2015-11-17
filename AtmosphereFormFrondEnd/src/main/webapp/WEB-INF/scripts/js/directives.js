app.directive('fileInput', [ '$parse', function($parse) {
	return {
		restrict : 'A',
		link : function(scope, elm, attrs) {
			elm.bind('change', function() {
				$parse(attrs.fileInput).assign(scope, elm[0].files)
				scope.$apply();
			})
		}
	}

} ]);

//app.directive('showErrors', function (showErrorsConfig) {
//    var getShowSuccess;
//    getShowSuccess = function (options) {
//      var showSuccess;
//      showSuccess = showErrorsConfig.showSuccess;
//      if (options && options.showSuccess != null) {
//        showSuccess = options.showSuccess;
//      }
//      return showSuccess;
//    }});

app.directive('uiSelectRequired', function() {
	return {
		require : 'ngModel',
		link : function(scope, element, attrs, ngModel) {
			scope.$watch(function() {
				return ngModel.$modelValue;
			}, function(newValue) {

				if (ngModel.$modelValue != undefined) {

					ngModel.$setValidity("required", true);
				} else {
					ngModel.$setValidity("required", false);
				}
			});
		}
	};
});
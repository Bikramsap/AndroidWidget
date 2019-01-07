var exec = require('cordova/exec');

exports.coolMethod = function (arg0, success, error) {
    exec(success, error, 'AndroidWidgets', 'coolMethod', [arg0]);
};

module.exports.displayTime = function(arg0, success, error)
{
    exec(success, error, 'AndroidWidgets', 'displayTime', [arg0]);
}

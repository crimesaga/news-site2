// Generated on 2014-09-09 using generator-angular 0.9.7
'use strict';

// # Globbing
// for performance reasons we're only matching one level down:
// 'test/spec/{,*/}*.js'
// use this if you want to recursively match all subfolders:
// 'test/spec/**/*.js'

module.exports = function (grunt) {

  // Load grunt tasks automatically
  require('load-grunt-tasks')(grunt);

  // Time how long tasks take. Can help when optimizing build times
  var timeGrunt = require('time-grunt')(grunt);

  // Configurable paths for the application
  var appConfig = {
    app: require('./bower.json').appPath || 'src/main/webapp',
    dist: 'dist',

    html: [ 'src/index.html' ],
    stylus: {
      main: 'src/styles/main.styl',
      login: 'src/modules/login/login.styl'
    }
  };
  var taskConfig = {
    /**
     * We read in our `package.json` file so we can access the package name and
     * version. It's already there, so we don't repeat ourselves here.
     */
    pkg: grunt.file.readJSON('package.json'),

    /**
     * The directories to create when `grunt bower:install` is executed.
     */
    bower: {
      install: {
        options: {
          targetDir: 'resources/dist/vendor',
          layout: 'byComponent',
          update: true,
          copy: true,
          verbose: false,
          cleanTargetDir: false,
          cleanBowerDir: false,
          bowerOptions: {}
        }
      }
    }

   
  };

  grunt.initConfig(grunt.util._.extend(taskConfig, timeGrunt));
  /**
   * The default task is to build and compile.
   */
  grunt.registerTask('default', [
    'bower:install'
  ]);
};

spring-data-gae
===============

A sample application for Spring Data running on Google App Engine (GAE)

## Usage

To generate the Eclipse project files, type `gradle cleanEclipse eclipse`

For detailed illustration of the gradle config, please refer to this [blog](http://tommysiu.blogspot.hk/2014/01/gradle-project-template-for-eclipse.html).

For details about this example, please refer to the following blogs:

* [Spring Data on GAE - Part 1 - Basic JPA]
* [Spring Data on GAE - Part 2 - Datastore Key]
* [Spring Data on GAE - Part 3 - Custom Repository]


__Note__: to preserve the folder hierarchy, the file .gitignore has been put in several places. Remove them when you put real files into the project otherwise those files will be ignored by git.

## Directory Layout

    src/                --> src folder (all empty except .gitignore)
      main/             
        java/           
        resource/       
      test/             
        java/           
        resource/       
    war/                --> the web resources
      css/              
      js/               
      WEB-INF/
        classes/
        jsp/
        lib/

[Spring Data on GAE - Part 1 - Basic JPA]: http://tommysiu.blogspot.hk/2014/01/spring-data-on-gae-part-1.html
[Spring Data on GAE - Part 2 - Datastore Key]: http://tommysiu.blogspot.hk/2014/02/spring-data-on-gae-part-2-datastore-key.html
[Spring Data on GAE - Part 3 - Custom Repository]: http://tommysiu.blogspot.hk/2014/02/spring-data-on-gae-part-3-custom.html

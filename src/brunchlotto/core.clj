(ns brunchlotto.core
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.util.anti-forgery :refer [anti-forgery-field]]
            [ring.util.response :as response]
            [brunchlotto.views.layout :as layout]
            [brunchlotto.views.contents :as contents]
            [hiccup.core :refer [html h]]
            [hiccup.form :as form]
            [hiccup.element :refer [image link-to]]
            [hiccup.page :refer [html5]]))

(defroutes app-routes
  (GET "/" [] (layout/application "Home" (contents/index)))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))

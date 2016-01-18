(ns brunchlotto.views.contents
    (:use [hiccup.form]
                  [hiccup.element :only (link-to)]))

(defn index []
    [:div {:id "content"}
        [:h1 {:class "text-success"} "Brunching with gas"]])

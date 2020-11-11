(ns kotws.pages.left-panel
  (:require [kotws.multi-language :as ml]
            ))

(defn panel []
  [:nav#mySidebar.w3-sidebar.w3-collapse.w3-white.w3-animate-left
     {:style "z-index:3;width:300px;"}
     [:br]
     [:div.w3-container
      [:a.w3-hide-large.w3-right.w3-jumbo.w3-padding.w3-hover-grey
       {:title "close menu", :onClick "w3_close()", :href "#"}
       [:i.fa.fa-remove]]
      [:img.w3-round
       {:style "width:45%;", :src "/w3images/avatar_g2.jpg"}]
      [:br]
      [:br]
      [:h4 [:b "PORTFOLIO"]]
      [:p.w3-text-grey "Template by W3.CSS"]]
     [:div.w3-bar-block
      [:a.w3-bar-item.w3-button.w3-padding.w3-text-teal
       {:onClick "w3_close()", :href "#portfolio"}
       [:i.fa.fa-th-large.fa-fw.w3-margin-right]
       "PORTFOLIO"]
      " \n    "
      [:a.w3-bar-item.w3-button.w3-padding
       {:onClick "w3_close()", :href "#about"}
       [:i.fa.fa-user.fa-fw.w3-margin-right]
       "ABOUT"]
      " \n    "
      [:a.w3-bar-item.w3-button.w3-padding
       {:onClick "w3_close()", :href "#contact"}
       [:i.fa.fa-envelope.fa-fw.w3-margin-right]
       "CONTACT"]]
     [:div.w3-panel.w3-large
      [:i.fa.fa-facebook-official.w3-hover-opacity]
      [:i.fa.fa-instagram.w3-hover-opacity]
      [:i.fa.fa-snapchat.w3-hover-opacity]
      [:i.fa.fa-pinterest-p.w3-hover-opacity]
      [:i.fa.fa-twitter.w3-hover-opacity]
      [:i.fa.fa-linkedin.w3-hover-opacity]]]
)

(defn panel-old []
  [:ul
   [:li [:a {:href "#/"} "Home"]]
   [:li {:class "dropdown"}
    [:a {:href "#/blog-cc-clojure"} "Blog"]
    [:div {:class "dropdown-content"}
     [:a {:href "#"} "Link 1"]
     [:a {:href "#"} "Link 2"]
     ]
    ]
   [:li [:a {:href "#/coi"} "COI"]]
   [:li [:a {:href "#/cv"} "CV"]]
   [:li [:a {:href "#/biblio" } "Biblio"]]
   [:li [:a {:href "#/about"} (ml/get-msg :about)]]
   ]
  )

(ns kotws.components.v-space)

(defn vertical-spacing
  "Creates a vertical space between two elements that disappear on small screens"
  []
  [:div.w3-hide-small.w3-row {:style {:height "2em"}}])

(defn vh-spacing
  "Creates a vertical space between two elements that disappear on small screens"
  []
  [:div.w3-hide-small.w3-row {:style {:height "2vh"}}])

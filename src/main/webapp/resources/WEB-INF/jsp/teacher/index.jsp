<h1>
  Providers
</h1>
<p>
  (An example table + detail view scenario)
</p>
<main>
  <table>
    <thead>
      <tr>
        <th>
          Provider Name
        </th>
        <th>
          E-mail
        </th>
        <th></th>
      </tr>
    </thead>
    <tfoot>
      <tr>
        <th>{:colspan => "3"}
          Year: 2014</th>
      </tr>
    </tfoot>
    <tbody>
      <tr>
        <td>{:data => {:title => "Provider Name"}}
          Iacob Geaorgescu</td>
        <td>{:data => {:title => "E-mail"}}
          e-mail@test-email.com</td>
        <td>{:class => "select"}
          <a>{:href => "#",:class => "button"}
            Select</a></td>
      </tr>
      <tr>
        <td>{:data => {:title => "Provider Name"}}
          Julius Neumann</td>
        <td>{:data => {:title => "E-mail"}}
          e-mail@test-email.com</td>
        <td>{:class => "select"}
          <a>{:href => "#",:class => "button"}
            Select</a></td>
      </tr>
      <tr>
        <td>{:data => {:title => "Provider Name"}}
          Christoph Koller</td>
        <td>{:data => {:title => "E-mail"}}
          e-mail@test-email.com</td>
        <td>{:class => "select"}
          <a>{:href => "#",:class => "button"}
            Select</a></td>
      </tr>
      <tr>
        <td>{:data => {:title => "Provider Name"}}
          Bram Lemmens</td>
        <td>{:data => {:title => "E-mail"}}
          e-mail@test-email.com</td>
        <td>{:class => "select"}
          <a>{:href => "#",:class => "button"}
            Select</a>
        </td>
      </tr>
    </tbody>
  </table>
  <div class="detail">
    <div class="detail-container">
      <dl>
        <dt>
          Provider Name
        </dt>
        <dd>
          John Doe
        </dd>
        <dt>
          E-mail
        </dt>
        <dd>
          email@example.com
        </dd>
        <dt>
          City
        </dt>
        <dd>
          Detroit
        </dd>
        <dt>
          Phone-Number
        </dt>
        <dd>
          555-555-5555
        </dd>
        <dt>
          Last Update
        </dt>
        <dd>
          Jun 20 2014
        </dd>
        <dt>
          Notes
        </dt>
        <dd>
          Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec odio. Quisque volutpat mattis eros. Nullam malesuada erat ut turpis. Suspendisse urna nibh, viverra non, semper suscipit, posuere a, pede.
        </dd>
      </dl>
    </div>
    <div class="detail-nav">
      <button class="close">
        Close
      </button>
    </div>
  </div>
</main>